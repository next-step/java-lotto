package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new TreeSet<>(parseLottoNumber(numbers));
        validate();
    }

    public Lotto(LottoGenerator lottoGenerator) {
        this(lottoGenerator.generate());
    }

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    private List<LottoNumber> parseLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(value -> new LottoNumber(value))
                .collect(Collectors.toList());
    }

    private void validate() {
        if (this.numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d개이어야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    public List<Integer> numbers() {
        return this.numbers.stream().map(lottoNumber -> lottoNumber.value()).collect(Collectors.toList());
    }

}
