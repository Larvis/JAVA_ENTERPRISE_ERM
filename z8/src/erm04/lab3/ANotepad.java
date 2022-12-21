/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
/**
 * Абстрактный класс Блокнот
 * @author Dev
 */
public abstract class ANotepad implements INotepad {

     /**
     * Randomizer 
     */
    public class Random {
        public Random()
        {
            super();
        }
   
        public int GetRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }
        
        public double GetMathRandom() {
            return Math.random();
        }
    }
    
//    private GetRandomNumber getRandomNumber;

    /**
     * Добавить текст
     *
     * System.out success Text
     */
    @Override
    public void textAdd(String text) {
        System.out.println("|==============================");
        System.out.println("Добавлен текст: " + text);
    }
    
    /**
     * Скопировать текст
     *
     * System.out success Text
     * @param text
     */
    @Override
    public void textCopy(String text) {
        System.out.println("|==============================");
        System.out.println("Текст скопирован: " + text);
    }
    
    /**
     * Удалить текст
     *
     * System.out success Text
     */
    @Override
    public void textDel(String text) {
        System.out.println("|==============================");
        System.out.println("Текст удален: " + text);
    }
    
    /**
     *  Вставить картинку из буфера
     *
     *  System.out success Text
     */
     @Override
     public void picPaste() {
        System.out.println("|==============================");
        System.out.println("Картинка добавлена!");
    }
   
     /**
     *  Удалить выбранную картинку
     *
     *  System.out success Text
     */
    @Override
    public void picDel(int picID) {
        System.out.println("|==============================");
        System.out.println("Картинка №" + picID + " удалена.");
    }
    
    /**
     *  Создать таблицу X*Y
     *
     *  System.out success Text
     */
    @Override
    public void tableAdd(int cols, int rows) {
        System.out.println("|==============================");
        System.out.println("Таблица " + cols + "x" + rows + " создана.");
    }
    
    /**
     *  Удалить таблицу №
     *
     *  System.out success Text
     */
    @Override
    public void tableDel(int tableID) {
        System.out.println("|==============================");
        System.out.println("Таблица №" + tableID + " удалена.");
    }
    
    /**
     *  Создать маркированный список List
     *
     *  System.out success Text
     * @param type
     * @return 
     */
//    @Override
     
    public void markListAddNew() {
        
        Scanner scanner = new Scanner(System.in);
        List<String> LList = new ArrayList<>();
        Set<String> SList = new HashSet<>();
        Map<Integer, String> MList = new HashMap<>();
        
        Random random = new Random();
        
        System.out.println("Построчно введите названия элементов (пустая строка завершает ввод): ");
        
        while(true)
        {
            System.out.print("* ");
            String item = scanner.nextLine();
           
            if (item.length() == 0) break;
            
            LList.add(item);
        }
        
        
        int randomInt = random.GetRandomNumber(1, 10);
        double randomMath = random.GetMathRandom();
        System.out.println(randomInt);
        System.out.println(randomMath);


        System.out.println("|==============================");
        System.out.println("Список создан: ");
        System.out.println(LList.size());

        LList = LList;
        
        for (String n : LList) {
            System.out.println("* " + n);
            
            SList.add(n);
            MList.put(randomInt, n);
        }
        LList.remove(1);
        MList.remove(1);
        
        System.out.println("|==============================");
        for (String n : LList) {
            System.out.println("* " + n);
        }
        
        System.out.println("|==============================");
        for (String n : SList) {
            System.out.println("* " + n);
        }
        
        System.out.println("|==============================");
        for (Integer i : MList.keySet()) {
            System.out.println("№" + i + " : " + MList.get(i));
        }
    }
    
    public void markListAdd() {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.print("Выберите тип списка 1 - Array list, 2 - HashSet, 3 - TreeMap: ");
            String type = scanner.next();
            
            switch (type) {
                case "1":
                    MethodArrayList();
                    return;
                case "2":
                    MethodHashSet();
                    return;
                case "3":
                    MethodTreeMap();
                    return;
                default:
                    System.out.println("Ошибка, неверно указан тип списка");
//                    return;
                    break;
            }
        }
    }
    
    private void MethodArrayList() {
        Scanner scanner = new Scanner(System.in);
        List<String> mList = new ArrayList<>();
        System.out.println("Построчно введите названия элементов (пустая строка завершает ввод): ");
        
        while(true)
        {
            System.out.print("* ");
            String item = scanner.nextLine();
           
            if (item.length() == 0) break;
            
            mList.add(item);
        }
        
        System.out.println("|==============================");
        System.out.println("Список создан: ");
        for (String n : mList) {
            System.out.println("* " + n);
        }
    }
    
    private void MethodHashSet() {
       Scanner scanner = new Scanner(System.in);
       Set<String> mList = new HashSet<>();
       System.out.println("Построчно введите названия элементов (пустая строка завершает ввод): ");
        
        while(true)
        {
            System.out.print("* ");
            String item = scanner.nextLine();
           
            if (item.length() == 0) break;
            
            mList.add(item);
        }
        
        System.out.println("|==============================");
        System.out.println("Уникальный список создан: ");
        
        for (String n : mList) {
            System.out.println("* " + n);
        }
    }
    
    private void MethodTreeMap() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> mList = new TreeMap<>(); //ASC or DESC
        System.out.println("Построчно введите названия элементов (пустая строка завершает ввод): ");
        
//        String item;
//        String position;
        while(true)
        {
            System.out.println("****** ");
            System.out.print("* ");
            String item = scanner.nextLine();
            
            if (item.length() == 0) break;
   
            System.out.print("№ ");
            String position = scanner.nextLine();
 
            mList.put(Integer.parseInt(position), item);
            
        }

        System.out.println("|==============================");
        System.out.println("Сортированный список создан: ");
        for (Integer i : mList.keySet()) {
            System.out.println("№" + i + " : " + mList.get(i));
        }
    } 
    
}
