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

        return directives.calculate();
    }

    private void isBlank(String s){
        s = s.trim();
        if (s.isBlank() || s.isEmpty()){
            System.out.println("계산할 값이 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    

}
