package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = generateRandomNumbers();
    }

    public Lotto(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> nums = IntStream.rangeClosed(START_RANGE, END_RANGE)// IntStream
            .boxed() // Stream<Integer>
            .collect(Collectors.toList()); // List<Integer>
        Collections.shuffle(nums);

        List<Integer> newNums = nums.subList(0, COUNT);
        Collections.sort(newNums);

        return newNums;
    }

    public int compareLottoAndWinnerNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isContain).count()).intValue();
    }

    public int compareLottoAndBonusNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isEqualBonusNumber).count()).intValue();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
