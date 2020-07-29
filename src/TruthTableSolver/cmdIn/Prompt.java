/*
 *<Truth Table Solver 1.2 Beta>
 *Copyright (C) <2011>  <Sherif Ahmed>
 *
 *This program is free software: you can redistribute it and/or modify
 *it under the terms of the GNU General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
///////////////////////////////////////////////////////////////////////

/*
 * prompt class is responsible of inputing
 * the data from the command line for the command line mode
 */

 package TruthTableSolver.cmdIn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prompt {

    private final BufferedReader in;

    public Prompt() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void opening() {
        System.out.println(
                "****************************************************************\n"+
                "*      ###   #   # #  ###  # #    ###   #   ##   #   ##        *\n"+
                "*       #   # #  # #   #   # #     #   # #  # #  #   #         *\n"+
                "*       #   ##   # #   #   ###     #   ###  ##   #   ##        *\n"+
                "*       #   # #  # #   #   # #     #   # #  # #  #   #         *\n"+
                "*       #   # #  ###   #   # #     #   # #  ##   ##  ##        *\n"+
                "*                                                              *\n"+
                "*                                                              *\n"+
                "*         ##  ###  #   # #  ##   #                             *\n"+
                "*         #   # #  #   # #  #   # #   1.3 Beta                 *\n"+
                "*         ##  # #  #   # #  ##  ##                             *\n"+
                "*          #  # #  #   # #  #   # #   By : Sherif Ahmed (95 %) *\n"+
                "*         ##  ###  ##   #   ##  # #        Julien Giraud (5 %) *\n"+
                "****************************************************************\n\n"+
                "This program solves the truth table and output all the possible minimized  \nequations.\n"
        );
    }

    public int promptSumOfProductsOrProductOfSums() throws Exception {
        String temp;
        System.out.println();

        do {
            System.out.print("enter 1 for sum of products or 2 for product of sums : ");
            temp = in.readLine();
            if (temp.equals("1")) {
                return 0;
            } else if (temp.equals("2")) {
                return 1;
            } else {
                System.out.println("\nerror : enter 1 for sum of products or 2 for product of sums.\n");
            }
        } while (!temp.equals("1") && !temp.equals("2"));

        return -1;
    }

    public int promptOneAllPossibleSolutionsOrOneSolution() throws Exception {
        String temp;
        System.out.println();

        do {
            System.out.print("enter 1 for (all possible solutions[occasionaly slow]) or \n2 (one solution only[fast]): ");
            temp = in.readLine();
            if (temp.equals("1")) {
                return 0;
            } else if (temp.equals("2")) {
                return 1;
            } else {
                System.out.println("\nerror : enter 1 for (all possible solutions[occasionaly slow]) or 2 (one solution only[fast]) .\n");
            }
        } while (!temp.equals("1") && !temp.equals("2"));

        return -1;
    }

}
