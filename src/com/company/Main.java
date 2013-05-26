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
        Employee salesman = new Employee(); //create new Employee class
        double total = salesman.promptForSales();
        salesman.GenerateComp(total);
    }
}