package step1;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String given){
        if(isNullinitValue(given)){
            return 0;
        }
        Numbers numbers = new Numbers(given);
        List<Integer> list = numbers.getNumbers();

        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }

    // TODO 생성자에서만 사용되는 메서드의 접근제한자 수정
    public static boolean isNullinitValue(String given){
        return given == null || given.isEmpty();
    }
}
