package step1.Util;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
    public static List<Integer> parseUnsignedInt(List<String> inputWords) {
        List<Integer> result = new ArrayList<>();
        for (String inputWord : inputWords) {
            result.add(Integer.parseUnsignedInt(inputWord));
        }
        return result;
    }
}
