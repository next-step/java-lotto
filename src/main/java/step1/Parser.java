package step1;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Integer[] parser(String[] inputStrings){
        List<Integer> resultNumbers = new ArrayList<>();
        for(String inputString : inputStrings){
            resultNumbers.add(parseInt(inputString));
        }
        return resultNumbers.toArray(new Integer[resultNumbers.size()]);
    }

    private static int parseInt(String inputString){
        int result;
        try {
            result = Integer.parseInt(inputString);
        }catch (Exception e){
            throw new RuntimeException();
        }
        validate_zero_more(result);
        return result;
    }

    private static void validate_zero_more(int inputNumbers){
        if(inputNumbers<0){
            throw new RuntimeException();
        }
    }
}
