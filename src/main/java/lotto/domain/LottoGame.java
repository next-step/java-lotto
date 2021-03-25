package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    Set<LottoNumber> numbers;

    public LottoGame(List<Integer> numbers) {
        this(castLottoNumberSet(numbers));
    }

    public LottoGame(Set<LottoNumber> numbers) {
        if (numbers.size() != LottoRule.countOfSelection()) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private static Set<LottoNumber> castLottoNumberSet(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::create)
                .collect(Collectors.toSet());
    }

    public int countOfMatch(LottoGame lottoGame) {
        return (int) this.numbers
                .stream()
                .filter(lottoGame::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> numbers() {
        return new ArrayList<>(this.numbers).stream()
                .sorted(LottoNumber::compare)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
