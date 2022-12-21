/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.*;

import java.util.Vector;
/**
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {

//    private static ElectronNotepad.Random rand;
    
    public static void main(String[] args) {     

//      New ENote
        ElectronNotepad e_notepad = new ElectronNotepad(); 
        e_notepad.setHeading("Новая запись1"); 
        e_notepad.setPages(30); 

       // Zadacha 1 / 2 / 3 
//        e_notepad.markListAddNew();
        
          ANotepad.Random rand = e_notepad.new Random();
          double rand_num = rand.GetMathRandom();
          System.out.println(rand_num);
          
          
          ArrayList<ElectronNotepad> list = new ArrayList();
//          list
//to comporate

//        G
//        ANotepad.GetRandomNumber grn = new ANotepad.GetRandomNumber();
//        int randomInt = e_notepad.GetRandomNumber.GetRandomNumber(1, 10);
        
    }
}

