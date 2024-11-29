package com.solution.hackerrank.quicksolve;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/21/2024 5:19 PM
@Last Modified 5/21/2024 5:19 PM
Version 1.0
*/

public class BukuV2 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal animal = new Animal();
        cat.sound(cat);
    }

    public static double myPow(double x, int n) {
        double result = x;

        while(x-- > 0) {
            result *= x;
        }
        return result;
    }


}

class Animal {
    void sound(Animal animal) {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    void sound(Cat cat) {
        System.out.println("Cat meows");
    }
}
