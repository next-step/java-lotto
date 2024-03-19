package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.StringToInt.toInt;

public class StringToList {
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
