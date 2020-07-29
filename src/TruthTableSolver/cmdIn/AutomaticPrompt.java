package TruthTableSolver.cmdIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AutomaticPrompt {

    private List<String> fileContent;
    private List<int[]> values; // the truth table values
    private int number_of_terms;
    private String terms_names[];
    private String output_terms_names[];
    private int sum_of_products_or_product_of_sums; // 0 for sum of products, 1 for product of sums
    private int all_possible_or_one_sol;

    private final Prompt prompt;

    public AutomaticPrompt() {
        prompt = new Prompt();
    }

    public List<int[]> getValues() {
        return values;
    }

    public int getNumberOfTerms() {
        return number_of_terms;
    }

    public String[] getTermsNames() {
        return terms_names;
    }

    public String[] getOutputTermsNames() {
        return terms_names;
    }

    public int getSumOfProductsOrProductOfSums() {
        return sum_of_products_or_product_of_sums;
    }

    public int getOneAllPossibleSolutionsOrOneSolution() {
        return all_possible_or_one_sol;
    }

    public void promptUser() throws Exception {
        prompt.opening();
        fileContent = promptFileContent();
        terms_names = promptTermsNames();
        number_of_terms = terms_names.length;
        output_terms_names = promptOutputTermsNames();
        values = promptValues();
        sum_of_products_or_product_of_sums = prompt.promptSumOfProductsOrProductOfSums();
        all_possible_or_one_sol = prompt.promptOneAllPossibleSolutionsOrOneSolution();
    }

    private List<String> promptFileContent() throws Exception {
        String fileSrc;
        List<String> content = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter filepath : ");
        try {
            fileSrc = in.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileSrc));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    content.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("\nerror : file not found.\n");
            System.exit(0);
        }

        return content;
    }

    private String[] promptTermsNames() {
        String header = fileContent.get(0);
        String inputsHeader = header.split(",")[0];
        return inputsHeader.split(" ");
    }

    private String[] promptOutputTermsNames() {
        String header = fileContent.get(0);
        String outputsHeader = header.split(", ")[1];
        return outputsHeader.split(" ");
    }

    private List<int[]> promptValues() {
        List<int[]> tab = new ArrayList<>();
        for (int i = 0; i < output_terms_names.length; i++) {
            int[] column = new int[(int)Math.pow(2, number_of_terms)];
            for (int j = 1; j < fileContent.size(); j++) {
                String outputs = fileContent.get(j).split(" ")[1];
                column[j - 1] = Integer.parseInt(outputs.substring(i, i+1));
            }
            tab.add(column);
        }
        return tab;
    }

}
