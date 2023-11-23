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
        Directives directives = new Directives(list);
        Numbers numbers = new Numbers(list);

        for (int i = 0; i < directives.getDirectivesSize(); i++) {
            Operator o = directives.findOperator(i);
            result = numbers.interact(o, result, i);
        }

        return result;
    }

    private void isBlank(String s){
        s = s.trim();
        if (s.isBlank() || s.isEmpty()){
            System.out.println("계산할 값이 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private int matchDirective(String directive, int a, int b){
        if (directive.equals("+")){
            return Operator.PLUS.calculate(a, b);
        }

        if (directive.equals("-")){
            return Operator.MINUS.calculate(a, b);
        }

        if (directive.equals("*")){
            return Operator.MULTIPLICATION.calculate(a, b);
        }

        if (directive.equals("/")){
            return Operator.DIVISION.calculate(a, b);
        }

        return 0;
    }
    

}
