package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(String[] list) {
        numbers = new ArrayList<>();
        for (String s : list) {
            createNumbers(s);
        }
    }

    public int interact(String s, int result, int index){
        if (index == 0){
            result = numbers.get(0);
        }
        return matchDirective(s, result, numbers.get(index+1));
    }


    private int matchDirective(String directive, int a, int b){
        if (directive.equals("+")){
            return addition(a, b);
        }

        if (directive.equals("-")){
            return subtraction(a, b);
        }

        if (directive.equals("*")){
            return multiplication(a, b);
        }

        if (directive.equals("/")){
            return division(a, b);
        }

        return 0;
    }

    private int addition(int a, int b){
        return a+b;
    }

    private int subtraction(int a, int b){
        return a-b;
    }

    private int multiplication(int a, int b){
        return a*b;
    }

    private int division(int a, int b){
        return a/b;
    }

    private void createNumbers(String s){
        if (matchNumber(s)){
            numbers.add(stringToInteger(s));
        }
    }

    private boolean matchNumber(String s){
        return s.matches("\\d*");
    }

    private int stringToInteger(String s){
        return Integer.parseInt(s);
    }



}
