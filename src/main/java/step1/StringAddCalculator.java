package step1;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String given){
        if(isNullinitValue(given)){
            return 0;
        }
        Numbers numbers = new Numbers(given, new StringSplitter());
        List<Integer> list = numbers.getNumbers();

        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }

    private static boolean isNullinitValue(String given){
        return given == null || given.isEmpty();
    }
}
