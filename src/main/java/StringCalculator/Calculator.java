package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String input){
        int result = 0;
        String[] list;

        isBlank(input);

        list = input.split(" ");

        List<String> directives = findDirective(list);
        List<Integer> numbers = findNumbers(list);

        if (directives.get(0).equals("+")){
            result = addition(numbers.get(0), numbers.get(1));
        }

        if (directives.get(0).equals("-")){
            result = subtraction(numbers.get(0), numbers.get(1));
        }

        if (directives.get(0).equals("*")){
            result = multiplication(numbers.get(0), numbers.get(1));
        }

        if (directives.get(0).equals("/")){
            result = division(numbers.get(0), numbers.get(1));
        }

        return result;
    }

    private void isBlank(String s){
        s = s.trim();
        if (s.isBlank() || s.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
    
    private List<Integer> findNumbers(String[] list){
        List<Integer> numbers = new ArrayList<Integer>();
        for (String s : list) {
            if(s.matches("\\d*")){
                numbers.add(Integer.parseInt(s));
            }
        }
        return numbers;
    }

    private List<String> findDirective(String[] list){
        List<String> directives = new ArrayList<String>();
        for (String s : list) {
            if (s.matches("[+\\-/\\*]")){
                directives.add(s);
            }
        }
        return directives;
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
}
