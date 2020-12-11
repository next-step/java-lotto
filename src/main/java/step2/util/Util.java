package step2.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public static void getShuffled(List<Integer> selectedNumbers) {
        Collections.shuffle(lottoNumbers);

        for (int i = 0; i < 6; i++) {
            selectedNumbers.add(lottoNumbers.get(i));
        }
    }

    public static void getSorted(List<Integer> selectedNumbers) {
        Collections.sort(selectedNumbers);
    }
}
