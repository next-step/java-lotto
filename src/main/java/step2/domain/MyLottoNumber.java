package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static List<Integer> initLottoNumber() {
        return IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<List<Integer>> getMyLottoNumbers(List<Integer> initLottoNumbers, int ticketOfLotto) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < ticketOfLotto; i++) {
            lottoNumbers.add(setShuffleNumber(initLottoNumbers));
        }
        return lottoNumbers;
    }

    static List<Integer> setShuffleNumber(List<Integer> initLottoNumbers) {
        Collections.shuffle(initLottoNumbers);
        return initLottoNumbers
                .stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
