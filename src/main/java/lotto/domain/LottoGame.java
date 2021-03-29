package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private final Set<LottoNumber> numbers;

    public LottoGame(String numbers) {
        this(castToListInteger(numbers));
    }

    public LottoGame(List<Integer> numbers) {
        this(castLottoNumberSet(numbers));
    }

    public LottoGame(Set<LottoNumber> numbers) {
        if (numbers.size() != LottoRule.countOfSelection()) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
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
        return Collections.unmodifiableList(
                new ArrayList<>(numbers).stream()
                        .sorted(LottoNumber::compare)
                        .collect(Collectors.toList()));
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

    private static List<Integer> castToListInteger(String numbers) {
        numbers = numbers.replaceAll("\\s+", "");
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Set<LottoNumber> castLottoNumberSet(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::create)
                .collect(Collectors.toSet());
    }

}
