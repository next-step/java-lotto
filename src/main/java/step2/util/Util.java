package step2.util;

import step2.domain.LottoNumber;

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

    public static List<LottoNumber> getShuffled() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBERS_LENGTH; i++) {
            numbers.add(new LottoNumber(lottoNumbers.get(i)));
        }

        return numbers;
    }

    public static void getSorted(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers, new LottoNumber.SortByLottoNumber());
    }
}
