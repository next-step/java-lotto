package stringCalculator;

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

    public int interact(Operator o, int result, int index){
        if (index == 0){
            result = numbers.get(0);
        }
        return o.calculate(result, numbers.get(index+1));
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
