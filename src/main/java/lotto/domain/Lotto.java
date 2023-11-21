package lotto.domain;

import lotto.dto.WinningInfoDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1_000;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto() {
        List<Integer> numbersRange = new ArrayList<>();
        for (int number = START_NUMBER; number <= END_NUMBER; number++) {
            numbersRange.add(number);
        }
        Collections.shuffle(numbersRange);
        this.numbers = new ArrayList<>(purchasing(numbersRange));

    }

    public Lotto(String numbers) {
        this.numbers = new ArrayList<>(Parser.numbersParsing(numbers));
    }

    private List<Integer> purchasing(List<Integer> numbersRange) {
        List<Integer> game = numbersRange.subList(0, 6);
        Collections.sort(game);
        return game;
    }

    public WinningInfoDTO winningInfo(WinningNumbersDTO winningNumbersDTO) {
        WinningNumber winningNumbers = winningNumbersDTO.getWinningNumbers();
        BonusNumber bonusNumber = winningNumbersDTO.getBonusNumber();
        int correctCount = winningNumbers.correctCount(numbers);
        boolean bonusCorrect = bonusNumber.belongs(numbers);
        return new WinningInfoDTO(correctCount, bonusCorrect, new Amount(Winning.winningAmount(correctCount, bonusCorrect)));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
