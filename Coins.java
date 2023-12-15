import java.util.Scanner;  //to get user input


public class Coins {
    public static void main(String[] args) { //main method
        Scanner scanner = new Scanner(System.in);//declare scanner
        System.out.println("Enter an amount in cents:"); //ask for user input
        int money = scanner.nextInt();//obtain user input
        System.out.println("This amount can be changed in the following ways:"); //formatting the output
        ways(0, money, 0, 0); //call on method to calculate change and pass the info to method
    }

    public static void ways(int dime, int money, int nickel, int count) {
        if (dime <= money) { // conditional to check amount of money and what coins needed
            int pennies = money - dime - nickel;  //initialize pennies
            System.out.println(++count + ") " + dime / 10 + " dime(s), " + nickel / 5 + " nickel(s), " + pennies + " penny(ies)");
            if (nickel + 5 <= money - dime) { //nested conditions
                ways(dime, money, nickel + 5, count);
            } else if (dime + 10 <= money) {  //nested conditions
                ways(dime + 10, money, 0, count);
            }
        }
    }
}
