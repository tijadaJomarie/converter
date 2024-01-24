import java.util.Scanner;
public class conversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu = true;//Boolean flag that controls the main loop.
        String binary_value = "";//String initialized to store the binary input.
        System.out.println("-------- Number System Converter -------");

        main_menu://Main labeled loop displaying the menu and process user input.
        while (menu) {//Performs the code if the menu is true.
            System.out.println("[1] Decimal to Octal\n[2] Binary to Decimal");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {//Evaluates if the user has entered an integer for the choice.
                int choice = input.nextInt();//Stores the user's choice value.
                input.nextLine();//Clears the newline character.

                System.out.println("----------------------------------------");

                switch (choice) {//Performs the conversion based on the chosen option.
                    case 1://Decimal to Octal
                        System.out.print("Enter a decimal value: ");
                        int decimal_input = 0;

                        if (input.hasNextInt()) {//Evaluates if the input is a valid integer.
                            decimal_input = input.nextInt();
                            input.nextLine();//Clears the newline character.
                        } else {//When the user has inputted a non integer value.
                            System.out.println("Invalid input. Please input a valid value.");
                            break main_menu;//Exits the loop if non integer.
                        }

                        int decimal_val = decimal_input;//Stores the decimal value inputted by the user.

                        System.out.println("----------------------------------------");

                        int octal_base = 1;//Represents the multiplier for each digit in the octal conversion (power of 8).
                        int octal_equivalent = 0;//Accumulate the octal equivalent of the given decimal number.

                        while (decimal_input > 0) {//Performs the decimal to octal conversion until the decimal number becomes 0.
                          //gives the remainder when "decimal_input" is divided by 8, multiplying it by "octal_base" adjusts its position.
                            octal_equivalent += (decimal_input % 8 * octal_base);
                            decimal_input /= 8;//Removes the rightmost digit from the decimal number.
                            octal_base *= 10;//
                        }
                        System.out.println(decimal_val + " (base 10) " + "in octal is: " + octal_equivalent + " (base 8) ");
                        break;

                    case 2://Binary to Decimal
                        System.out.print("Enter a binary value: ");
                        binary_value = input.nextLine();

                        for (int i = 0; i < binary_value.length(); i++) {//Iterates over each character in the "binary_value".
                            char ch = binary_value.charAt(i);//Returns the character at the current index i from the "binary_value".
                            if (ch != '0' && ch != '1') {//Evaluates the character is neither '0' nor '1', as it is an invalid character for binary input.
                                System.out.println("Invalid binary input. Please enter a valid binary value.");
                                break main_menu;//Exits the main menu loop.
                            }
                        }

                        int decimal_equivalent = 0;//Accumulates the decimal equivalent of the given binary number.
                        int binary_base = 1;//Represents the positional value of the current binary digit being converted.

                        for (int i = binary_value.length() - 1; i >= 0; i--) {//Iterates through each binary digit in reverse order.
                            int octal_digit = binary_value.charAt(i) - '0';//Convert the character representation of the digit to its integer value.
                            decimal_equivalent += octal_digit * binary_base;//adds the product of the current binary digit.
                            binary_base *= 2;//positional values increase by powers of 2. 
                        }
                        System.out.println(binary_value + " (base 2) " + "in decimal is: " + decimal_equivalent + " (base 10) ");
                        break;//Exits the loop.

                    default://Executed when none of the other cases match the given choice value.
                        System.out.println("Out of range.");
                        break main_menu;//Exits the main menu loop.
                }
            } else {//Handles the case when the user input is not a valid integer.
                System.out.println("Invalid input");
                input.nextLine();
                System.out.print("Do you want to try again? (Y/N): ");
                String resp = input.nextLine();
                if (resp.equalsIgnoreCase("Y")) {//Evaluates if the user wants to try again by comparing the response (ignoring case) with the string "Y".
                    continue main_menu;//Skips the rest of the current iteration of the labeled loop.
                } else {
                    menu = false;//Terminates the main loop 
                }
            }

            System.out.println("----------------------------------------");
            System.out.print("Do you want to continue? (Y/N): ");
            String respond = input.nextLine();
            if (respond.equalsIgnoreCase("Y")) {//Evaluates if the user wants to try again by comparing the response (ignoring case) with the string "Y".
                System.out.println("Okay!");
                System.out.println("----------------------------------------");
                continue main_menu;//Skips the rest of the current iteration of the labeled loop.
            } else {
                System.out.println("\nThank you for using me!");
                menu = false;//Terminates the main loop .
            }
        }
        input.close();//Closes the scanner.
    }
}