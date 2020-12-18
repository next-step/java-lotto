package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(Constants.LOTTO_BALL_START_NUMBER,Constants.LOTTO_BALL_END_NUMBER)
                                                                .boxed()
                                                                .collect(Collectors.toList());

    public static List<Integer> getShuffled() {
        Collections.shuffle(lottoNumbers);

        List<Integer> selectedNumbers = new ArrayList<>();

        for (int i = 0; i < Constants.LOTTO_NUMBERS_LENGTH; i++) {
            selectedNumbers.add(lottoNumbers.get(i));
        }

        return selectedNumbers;
    }

    public static void getSorted(List<Integer> selectedNumbers) {
        Collections.sort(selectedNumbers);
    }
}
