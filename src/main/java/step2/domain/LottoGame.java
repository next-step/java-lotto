package step2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private final List<Integer> lottoGame;

    public LottoGame(List<Integer> numbers) {
        validInputNumber(numbers);
        this.lottoGame = numbers;
    }

    public LottoGame(Set<Integer> numbers) {
        validInputNumber(numbers);
        lottoGame = new ArrayList<>(numbers);
    }

    private static void validInputNumber(Collection<Integer> numbers) {
        if (numbers.size() != LottoCommonValue.DEFAULT_LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException(numbers + " : 입력한 숫자를 확인해 주세요");
        }
    }

    public boolean isContain(Integer number) {
        return this.lottoGame.contains(number);
    }

    public long howManyRight(LottoGame compareTarget) {
        return lottoGame.stream()
                .filter(i -> compareTarget.isContain(i))
                .count();
    }

    @Override
    public String toString() {
        return lottoGame.toString();
    }

}
