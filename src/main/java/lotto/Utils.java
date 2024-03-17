package lotto;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int toInt(String values){
        return checkPositive(values);
    }

    private static int checkPositive(String value){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력");
        }
        if (result < 0){
            throw new IllegalArgumentException("음수 입력");
        }
        return result;
    }

    public static List<Integer> toList(String value){
        String[] intValue= value.split(",");
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<intValue.length;i++){
            String noBlank = intValue[i].replaceAll(" ",  "");
            result.add(toInt(noBlank));
        }
        return result;
    }

}
