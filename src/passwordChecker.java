/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author obmr
 */
public class passwordChecker {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);

        System.out.println("BAD PASSWORD CHECKER ENTER PASSWORD");
        System.out.println("-------------------------------");
        String password = input.next();
        
        passChecker(password);
        
    }
    
    
    
    public static void passChecker(String password) throws FileNotFoundException{
        
        Map<String, Integer> pass = new HashMap<>();
        Map<String, Integer> dictionary = new HashMap<>();

        Scanner com = new Scanner(new File("mostCommon.txt"));
        Scanner dic = new Scanner(new File("dictionary.txt"));

        while (com.hasNextLine()) {
            pass.put(com.nextLine(), 1);
        }
        while (dic.hasNextLine()) {
            dictionary.put(dic.nextLine(), 1);
        }

        if (password.length() < 5) {          
            System.out.println("*Password Must Contain Atleast 5 Characters");
        }

        if (pass.containsKey(password)) {                            //Check if password is one of common passwords word
            System.out.println("*Password Is Commonly Used");
        }

        if (dictionary.containsKey(password)) {                      //Check if password is one of dictionary word
            System.out.println("*Password Is in dictionary ");
        }

        if(password.length() < 5 || pass.containsKey(password) || dictionary.containsKey(password)){  
            System.out.println("BAD PASSWORD");
            System.exit(0);
        }
        
        
       String word = "";
        int i;
        for (i = 0; i < password.length(); i++) {                   //To extract the part after number
           if (!Character.isDigit(password.charAt(i))) {
             break;
            }   
        }
           word = password.substring(i,password.length());
           if(dictionary.containsKey(word)){
               System.out.println("BAD PASSWORD");
               System.out.println("password contain a number before a word from the dictionary");
                System.exit(0);
           }
           
           
        String word1 = "";  
        int j;
        for (j = 0; j < password.length(); j++) {                   //To extract the part before number
            if (Character.isDigit(password.charAt(j))) {
                break;
            }
        }
        word1 = password.substring(0, j);
        if (dictionary.containsKey(word1)) {
            System.out.println("BAD PASSWORD");
            System.out.println("password contain a number after a word from the dictionary");
             System.exit(0);
        }
        
        
        
             String s = "";
        int x;
        for (x = 0; x < password.length(); x++) {                   //simple passwords 
            if (!Character.isDigit(password.charAt(x))) {
                break;
            }
        }
        s = password.substring(x, password.length());
        if (s.length() <= 5) {
            System.out.println("SIMPLE PASSWORD");
            System.exit(0);
        }

        
        
        String h = "";
        int y;
        for (y = 0; y < password.length(); y++) {                   //simple passwords
            if (Character.isDigit(password.charAt(y))) {
                break;
            }
        }
        h = password.substring(0,y);
        if (h.length() <= 5) {
            System.out.println("SIMPLE PASSWORD");
            System.exit(0);
        }

        
        System.out.println("PASSWORD IS GOOD OVERALL " + password);
        
        

    }

}
