/**
 *  Week 3 Assignment
 *  Eric Amrhein
 *  Programing 420
 *  Vikram Chowdiah
 */

package com.company; //Package Directory, Remove if File Directories are changed
public class Main
{

    public static void main(String[] args)
    {
        Employee salesman1 = new Employee(); //create first employee from Employee Class
        Employee salesman2 = new Employee(); //create second employee from Employee Class
        Employee.GenerateComparison(salesman1.promptForSales(),salesman2.promptForSales());                                            //generate Comparison between employee one and employee 2
        //salesman1.GenerateComp(salesman.total);       //Generate Annual Compensation Method
        //salesman1.GenerateTable(total);      //Generate Compensation Table Method

    }

}