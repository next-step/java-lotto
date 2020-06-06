package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumbers;

import java.util.List;

import static java.util.Collections.shuffle;

public class LottoTicketExtractor {
    public static final int ZERO_VALUE = 0;

    public static List<Integer> createShuffled(int maxSize) {
        LottoNumbers.validateMaxSize(maxSize);
        List<Integer> numbers = LottoNumbers.getNumbers();
        shuffle(numbers);

        return numbers.subList(ZERO_VALUE, maxSize);
    }
}
