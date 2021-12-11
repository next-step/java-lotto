package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumbers {

    private static final String ERR_MESSAGE_RANGE = "로또 숫자 범위를 확인해주세요 (입력범위 1 ~ 45)";
    private static final int END_NUMBER = 45;
    private static final int START_NUMBER = 1;
    public static final int MARKED_RANGE = 6;

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> autoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(MARKED_RANGE)
                .collect(Collectors.toList());
    }

    public static void valid(List<Integer> defaultNumbers) {
        defaultNumbers.forEach(AutoLottoNumbers::valid);
    }

    private static void valid(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new LottoNumberException(ERR_MESSAGE_RANGE);
        }
    }

}
