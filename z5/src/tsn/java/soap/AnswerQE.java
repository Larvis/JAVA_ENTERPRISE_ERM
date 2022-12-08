package tsn.java.soap;

import java.io.Serializable;

// Указываем через Serializable что класс будет способен работать в web-технологии SOAP
// ДЛЯ КАЖДОГО ПОЛЯ НУЖНЫ СЕТТЕРЫ И ГЕТТЕРЫ, А ТАКЖЕ ОБЪЗАТЕЛЕН ПУСТОЙ КОНСТРУКТОР !
public class AnswerQE implements Serializable {
//    private double a;
//    private double b;
//    private double x;
    private double y;

    public AnswerQE() {
    }

    public AnswerQE(double y) {
        this.y = y;
    }

   
    public void setY(double y) {
        this.y = y;
    }

//    public void setA(double a) {
//        this.a = a;
//    }
//
//    public void setB(double b) {
//        this.b = b;
//    }
//    public void setX(double x) {
//        this.x = x;
//    }
//     
//    public double getA() {
//        return a;
//    }
//
//    public double getB() {
//        return b;
//    }
//    
//    public double getX() {
//        return x;
//    }
    
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "y=" + y;
    }

}
