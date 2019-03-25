package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static int toInt(String purchase) {
        return Integer.parseInt(purchase);
    }

    public static String[] stringSplitWithDelimiter(String original, String delimiter) {
        original = original.replaceAll("\\s", "");
        return original.split(delimiter);
    }
}
