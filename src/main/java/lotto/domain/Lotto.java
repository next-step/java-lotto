package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = generateRandomNumbers();
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
}
