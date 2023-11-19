package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numbers = lottoGenerator.generate();
        validate();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        Set<Integer> lottoSet = Set.copyOf(this.numbers);
        if (lottoSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d개이어야 합니다.", LOTTO_NUMBER_COUNT));
        }

        long invalidNumberCount = this.numbers.stream().filter(value -> value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER).count();
        if (invalidNumberCount > 0) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d~%d 사이의 숫자만 가능합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    public LottoResult match(Lotto winningLotto) {
        int matchCount = (int) numbers.stream()
                .filter(number -> winningLotto.numbers.contains(number))
                .count();
        return LottoResult.findResult(matchCount);
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

}
