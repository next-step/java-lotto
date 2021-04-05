package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtil {
    private StringUtil() {
    }

    public static List<Integer> stringToList(String inputWinningLotto) {
        List<Integer> list = new ArrayList<>();
        String[] array = inputWinningLotto.split(",");
        for (int i = 0; i < array.length; i++) {
            list.add(Integer.parseInt(array[i]));
        }
        Collections.sort(list);
        return list;
    }
}
