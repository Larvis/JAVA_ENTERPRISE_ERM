/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kz.proffix4.telegrambot;

//import javax.accessibility.AccessibleContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author larvis
 */
 
class A
{
    public void print()
    {
        System.out.println("A.print() is called");
    }
}

class B extends A
{
    @Override
    public void print()
    {
         System.out.println("B.print() is called");
    }
}

    
public class Main
{
    public static void main(String[] args)
    {
        A var = new B();
        var.print();
    }
}