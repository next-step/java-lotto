package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorUtil {
    public static List<Integer> createNumbersFromOne(int totalNumberCount) {
        if(totalNumberCount < 1) {
            throw new IllegalArgumentException("최소 1이상의 숫자가 필요합니다.");
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= totalNumberCount; i++) {
            result.add(i);
        }
        return result;
    }

    public static List<Integer> randomNumbers(int numberCount, int count) {
        List<Integer> result = new ArrayList<>(createNumbersFromOne(numberCount));
        Collections.shuffle(result);
        return result.subList(0, count);
    }
}
