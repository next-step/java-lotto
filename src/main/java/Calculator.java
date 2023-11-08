public class Calculator {

    public static String[] splitText(String text){
        return text.split(" ");
    }

    public static int add(int number1, int number2){
        return number1 + number2;
    }

    public static int subtract(int number1, int number2){
        return number1 - number2;
    }

    public static int multiply(int number1, int number2){
        return number1 * number2;
    }

    public static int divide(int number1, int number2){
        return number1 / number2;
    }

    public static void checkDivideValue(int number1, int number2){
        if(number1 % number2!=0){

        }

    }

    public static boolean isBlank(String input){
        return " ".equals(input);
    }



}
