package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final int LOTTO_BALL_START_NUMBER = 1;
    private static final int LOTTO_BALL_END_NUMBER = 45;

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_BALL_START_NUMBER, LOTTO_BALL_END_NUMBER)
                                                                .boxed()
                                                                .collect(Collectors.toList());

    public static List<Integer> getShuffled() {
        Collections.shuffle(lottoNumbers);

        List<Integer> selectedNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBERS_LENGTH; i++) {
            selectedNumbers.add(lottoNumbers.get(i));
        }

        return selectedNumbers;
    }

    public static void getSorted(List<Integer> selectedNumbers) {
        Collections.sort(selectedNumbers);
    }
}
