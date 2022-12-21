/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.*;
/**
 * Интерфейс INotepad
 * @author Dev
 */

public interface INotepad {
    
    /**
     *
     * @param text
     */
    void textAdd(String text);  // Добавить текст

    /**
     *
     *  Скопировать текст
     */
    void textCopy(String text); 

    /**
     *
     * @param text
     */
    void textDel(String text);  // Удалить текст

    /**
     *
     */
    void picPaste();  /* Вставить картинку из буфера */

    /**
     *
     * @param picID
     */
    void picDel(int picID);  // Удалить выбранную картинку

    /**
     *
     * @param cols
     * @param rows
     */
    void tableAdd(int cols, int rows);  // Создать таблицу X*Y

    /**
     *
     * @param tableID
     */
    void tableDel(int tableID);  //  Удалить таблицу №

    /**
     *
     * @param 
     */
    void markListAdd();  // Создать маркированный список
    
    /**
     *
     * @param 
     */
    void markListAddNew();  // Создать маркированный список V2
    
}
