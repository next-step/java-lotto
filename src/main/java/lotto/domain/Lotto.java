package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().map(value -> new LottoNumber(value)).collect(Collectors.toList());
        validate();
    }

    public Lotto(LottoGenerator lottoGenerator) {
        this(lottoGenerator.generate(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
    }

    private void validate() {
        Set<LottoNumber> lottoSet = Set.copyOf(this.numbers);
        if (lottoSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d개이어야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    public LottoResult match(Lotto winningLotto) {
        int matchCount = (int) numbers.stream()
                .filter(number -> winningLotto.numbers.contains(number))
                .count();
        return LottoResult.findResult(matchCount);
    }

    public List<Integer> numbers() {
        return this.numbers.stream().map(lottoNumber -> lottoNumber.value()).collect(Collectors.toList());
    }

}
