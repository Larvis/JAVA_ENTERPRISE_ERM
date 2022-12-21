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
/**
 * Абстрактный класс Параметры Блокнота
 * @author Dev
 */
public abstract class NotepadParams extends ANotepad{
    
    private String hiddenText;
    private String type;
    private String heading; // Заголовок
    private int pages; // Количество страниц
    

//    public NotepadParams() {
//        super.type = "Блокнот";
//    }
//    
    // Default constructor
    public NotepadParams() {
        type = "---"; 
        heading = "New note"; 
        pages = 1; 
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    // Fully constructor
    public NotepadParams(int pages, String heading) {
        this.heading = heading; 
        this.pages = pages; 
    }
    
    // pages
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    
    // format
    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }
    
    // Переопределение метода "toString" для печати объектов класса
    @Override
    public String toString() {
        return "type=" + type + ", heading=" + heading + ", pages=" + pages;
    }
    
}
