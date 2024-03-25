package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringToInt {
    public static int toInt(String values){
        return checkPositive(values);
    }

    public static int toIntManual(int num, String values){
        int result = checkPositive(values);
        if(num < result){
            throw new IllegalArgumentException("구매 개수보다 수동 개수가 더 작아야함");
        }
        return result;
    }


    private static int checkPositive(String value){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력");
        }
        if (result < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
        return result;
    }



}
