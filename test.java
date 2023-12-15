import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'countValidWords' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int countValidWords(String s) {
    // Write your code here
        int numValid = 0; //Variable for the number of valid words
        String [] subString = s.split("\\s+"); //We will create an array to hold each word in the string
        
        for(int x = 0; x < subString.length; x++){ //Go through each word in the array
            int wordLength = 0; //Variable to keep track of the length of each word
            String currentWord = subString[x]; //Variable to extract each word in the string array
            
            for(int i = 0; i < currentWord.length(); i++){ //Go through each character in the word
                //Check whether character meets the given requirements
                if ((currentWord.charAt(i) >= 'A' && currentWord.charAt(i) <= 'Z') || (currentWord.charAt(i) >= 'a' && currentWord.charAt(i) <= 'z') || (currentWord.charAt(i) >= '1' && currentWord.charAt(i) <= '9')){
                    
                    
    
                }
                
            }
            
            
        }      
        return numValid;

    }

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

class User {
    String name;
    String email;
    int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > 100) {
            throw new IllegalArgumentException("Name property is invalid");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.length() > 100 || !email.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}")) {
            throw new IllegalArgumentException("Email property is invalid");
        }
    }

    private void validateAge(int age) {
        if (age < 18 || age > 120) {
            throw new IllegalArgumentException("Age property is invalid");
        }
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
         Scanner scanner = new Scanner(System.in);

        // Read input
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        User user = new User(name, email, age);
        
        System.out.println(user.name); //Output original name
        System.out.println(user.email); //Output original email
        System.out.println(user.age); //Output original age

        // Read new input
        String newName = scanner.nextLine();
        try {
            user.setName(newName);
            System.out.println(user.name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String newEmail = scanner.nextLine();
        try {
            user.setEmail(newEmail);
            System.out.println(user.email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int newAge = Integer.parseInt(scanner.nextLine());
        try {
            user.setAge(newAge);
            System.out.println(user.age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getMin(String s) {
        int isBalanced = 0; int insertions = 0; //Variable that keeps track of the balanced paranthesis as well as the insertions needed to balance them
        
        for (int x = 0; x < s.length(); x++){ //For loop to go through each paranthesis in the string
            if (s.charAt(x) == '('){ //Check if the character is an opening paranthesis '('
                isBalanced++; //Increment balanced counter for the opening paranthesis
            }
            else if (s.charAt(x) == ')'){ //Check whether it is a closing paranthesis
                isBalanced--; //Decrement balanced counter for closing paranthesis
            }
            
            if (isBalanced < 0){ //If the balanced counter is negative, it indicates that there was a closing paranthesis without an opening one
                //We will perform an insertion and then increment the balanced counter to maintain balance
                insertions++;
                isBalanced++;
            }
        }
        
        insertions += isBalanced; //Perform insertion for the remaining opening paranthesis
        
        return insertions; //Return total number of insertions
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.getMin(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
