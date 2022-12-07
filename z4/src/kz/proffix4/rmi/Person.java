package kz.proffix4.rmi;

import java.io.Serializable;

// Класс "Персона" с сериализацией для поддержки RMI
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private final double a, b, x;

    public Person(double a, double b, double x) {
        this.a = a;
        this.b = b;
        this.x = x;
    }

    public Double getA() {
        return this.a;
    }
     
    public Double getB() {
        return this.b;
    }
    
    public Double getX() {
        return this.x;
    }
 
    @Override
    public String toString() {
        return String.format("%s (age=%s)", a, b);
    }

}
