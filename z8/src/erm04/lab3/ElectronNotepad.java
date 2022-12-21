/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab3;

/**
 * Класс электронного блокнота
 * @author Dev
 */
public class ElectronNotepad extends NotepadParams {
    
//    public String hiddenText;
    
    public ElectronNotepad() {
        setType("Электронная заметка");
//        super.type = "Электронная заметка";
    }
    
     /**
     * Randomizer 
     */
    public class HiddenText {

        String hiddenText;

        public HiddenText(String hiddenText) {
            this.hiddenText = hiddenText;
        }
    }
}
