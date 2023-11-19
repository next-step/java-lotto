package lotto.domain;

import lotto.dto.WinningInfoDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

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
        int correctCount = correctCount(winningNumbersDTO.getWinningNumbers());
        int bonusCorrectCount = bonusCorrectCount(winningNumbersDTO.getBonusNumber());
        return new WinningInfoDTO(correctCount, bonusCorrectCount, new Amount(Winning.winningAmount(correctCount, bonusCorrectCount)));
    }

    private int correctCount(String numbers) {
        return Parser.numbersParsing(numbers)
                .stream()
                .filter(value -> this.numbers.contains(value))
                .collect(Collectors.toList())
                .size();
    }

    private int bonusCorrectCount(String numbers) {
        int bonusNumber = Parser.parseNumberFormat(numbers);
        return (int) this.numbers.stream()
                .filter(value -> value == bonusNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
