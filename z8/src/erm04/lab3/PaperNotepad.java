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
 * Класс бумажного блокнота
 * @author Dev
 */
public class PaperNotepad extends NotepadParams {
    public PaperNotepad() {
//        super.type = "Бумажный Блокнот";
        setType("Бумажный Блокнот");
    }

    @Override
    public void textAdd(String text) {
        System.out.println("Текст добавлен!");
    }
    
    @Override
    public void textCopy(String text) {
        System.out.println("Действие невозможно!");
    }

    @Override
    public void textDel(String text) {
        System.out.println("Действие невозможно!");
    }
    
    @Override
    public void picPaste() {
        System.out.println("Действие невозможно!");
    }
    
    @Override
    public void picDel(int picID) {
        System.out.println("Действие невозможно!");
    }

    @Override
    public void tableAdd(int cols, int rows) {
        System.out.println("Действие невозможно!");
    }
    
    @Override
    public void tableDel(int tableID) {
        System.out.println("Действие невозможно!");
    }

    @Override
    public void markListAdd() {
        System.out.println("Действие невозможно!");
    }
    
    @Override
    public void markListAddNew() {
        System.out.println("Действие невозможно!");
    }
    
    
}
