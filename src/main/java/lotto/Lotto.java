package lotto;

import util.Number;

import java.util.Arrays;
import java.util.Collections;

public class Lotto {
    private Integer[] lottoNumbers;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_START_INDEX = 0;
    private final int LOTTO_END_INDEX = 6;
    private final Integer[] LOTTO_AVAILABLE_NUMBERS = Number.rangeNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

    public Lotto() {
        Collections.shuffle(Arrays.asList(LOTTO_AVAILABLE_NUMBERS));
        lottoNumbers = Arrays.copyOfRange(LOTTO_AVAILABLE_NUMBERS, LOTTO_START_INDEX, LOTTO_END_INDEX);
        Arrays.sort(lottoNumbers);
    }


    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers);
    }
}
