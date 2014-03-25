/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testwai;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class TestWAI {
    
    public static void checker(Student first) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who am I? ");
        if(first.wai(scanner.next().toLowerCase())){
            System.out.println("Yeah! You are totally right!\n");
        } else {
            System.out.println("No :( The real answer is : " + first.getClass().getSimpleName() + '\n');
        }
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Student first = new Mathematician("John");
        System.out.println(first);
        checker(first);
        
        Student second = new Physicist("Garry");
        System.out.println(second);
        checker(second);
        
        Student third = new Physician("Bill");
        System.out.println(third);
        checker(third);
        
        Student fourth = new Chemist("Edward");
        System.out.println(fourth);
        checker(fourth);
        
        Student fifth = new Biologist("Leo");
        System.out.println(fifth);
        checker(fifth);
    }
    
}
