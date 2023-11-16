package domain;

import validator.LottoNumberValidator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<Integer> winnerNumbers;

    public WinningLotto(List<Integer> numbers) {
        this.winnerNumbers = numbers;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
