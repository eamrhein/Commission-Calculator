/**
 *  Week 3 Assignment
 *  Eric Amrhein
 *  Programing 420
 *  Vikram Chowdiah
 */

package com.company; //Package Directory, Remove if File Directories are changed


import java.math.BigDecimal;

public class Main
{

    public static void main(String[] args)
    {
        Employee salesman1 = new Employee(); //create first employee from Employee Class
        Employee salesman2 = new Employee(); //create second employee from Employee Class
        BigDecimal total1 = salesman1.Totalcommission(salesman1.promptForSales("first"));  // Prompts for name and sales, then generates annual compensation for the first employee
        BigDecimal total2 = salesman2.Totalcommission(salesman2.promptForSales("Second")); // Prompts for name and sales, then generates annual compensation for the second employee
        BigDecimal answer = Employee.CompareCompensation(total1,total2); //generate Comparison between employee one and employee two

        if (total1.compareTo(total2) > 0)
        {
           System.out.println(salesman1.name + " will make $" + answer +" more than " + salesman2.name + " this year.");
        }
        else if (total1.compareTo(total2)<0)
        {
           System.out.println(salesman2.name + " will make $" + answer + " more than " + salesman1.name + " this year.");
        }
        else
        {
           System.out.println(salesman1.name + " and " + salesman2.name + " will make an equal amount of money this year.");
        }

    }

}