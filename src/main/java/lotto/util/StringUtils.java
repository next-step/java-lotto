package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public String[] split(String input) {
        return input.replace(" ", "").split("[, ]");
    }

    public List<Integer> stringArrayToIntArray(String[] strings) {
        List<Integer> ints = new ArrayList<>();
        for (String string : strings) {
            ints.add(Integer.parseInt(string));
        }

        return ints;
    }
}
