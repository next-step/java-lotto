package lotto.game;

import lotto.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class Game {
    private final List<LottoNumber> lottoNumbers;

    public static Game generateGame(List<Integer> numbers) {
        return new Game(LottoNumber.toLottoNumbers(numbers));
    }

    public Game(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = numbers;
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리 숫자만을 선택할 수 있습니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또는 서로다른 6자리 숫자만을 선택할 수 있습니다.");
        }
    }

    public Rank win(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        int count = countMatch(numbers);
        return Rank.of(count);
    }

    private int countMatch(List<LottoNumber> numbers) {
        long count = numbers.stream()
                .map(this.lottoNumbers::contains)
                .filter(contain -> contain)
                .count();
        return Long.valueOf(count).intValue();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
