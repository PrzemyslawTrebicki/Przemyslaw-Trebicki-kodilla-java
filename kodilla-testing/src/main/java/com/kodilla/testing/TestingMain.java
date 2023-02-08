package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

import java.util.logging.SimpleFormatter;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")) {
            System.out.println("test OK!");
        } else {
            System.out.println("Error!\nUser name do not match.");
        }
        System.out.println("----- ----- -----");
        Calculator calculator = new Calculator(3, 2);
        int adding = calculator.add();
        if (adding == 5) {
            System.out.println("Funkcja dodawania jest OK!");
        } else {
            System.out.println("Funkcja dodawania nie dziala!");
        }
        //System.out.println("Wynik dodawania, metoda 1: "+calculator.add());
        //System.out.println("Wynik dodawania metoda 2: "+adding);
        if (calculator.subtract() == 1) {
            System.out.println("Funkcja odejmowania jest OK!");
        } else {
            System.out.println("Funkcja odejmowania nie dziala!");
        }

        //System.out.println("Wynik odejmowania: "+calculator.subtract());
    }
}
