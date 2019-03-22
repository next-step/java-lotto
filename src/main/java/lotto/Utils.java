package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static int toInt(String purchase) {
        return Integer.parseInt(purchase);
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> baseNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> baseNumbers.add(i));
        for (int i = 0; i < 6; i++) {
            Collections.shuffle(baseNumbers);
            numbers.add(baseNumbers.remove(0));
        }
        Collections.sort(numbers);

        return numbers;
    }

    public static String[] stringSplitWithDelimiter(String original, String delimiter) {
        original = original.replaceAll("\\s", "");
        return original.split(delimiter);
    }
}
