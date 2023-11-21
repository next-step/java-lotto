package lotto.domain;

import lotto.dto.WinningInfoDTO;
import lotto.dto.WinningNumbersDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public Lotto(String value) {
        List<Integer> numbers = new ArrayList<>(Parser.numbersParsing(value));
        validationCheck(numbers);
        this.numbers = numbers;
    }

    public int correctCount(List<Integer> values) {
        return values.stream()
                .filter(value -> this.numbers.contains(value))
                .collect(Collectors.toList())
                .size();
    }

    public boolean contains(int value) {
        return this.numbers.contains(value);
    }

    private List<Integer> purchasing(List<Integer> numbersRange) {
        List<Integer> game = numbersRange.subList(0, 6);
        Collections.sort(game);
        return game;
    }

    public WinningInfoDTO winningInfo(WinningNumbersDTO winningNumbersDTO) {
        Lotto winningLotto = winningNumbersDTO.getWinningNumbers();
        BonusNumber bonusNumber = winningNumbersDTO.getBonusNumber();
        int correctCount = winningLotto.correctCount(numbers);
        boolean bonusCorrect = bonusNumber.belongs(numbers);
        return new WinningInfoDTO(correctCount, bonusCorrect, new Amount(Winning.winningAmount(correctCount, bonusCorrect)));
    }

    private void validationCheck(List<Integer> list) {
        if (numberRangeCheck(list)) {
            throw new IllegalArgumentException("번호중 숫자 범위를 벗어나는 수가 있습니다. 숫자범위 : 1~45");
        }
        if (duplicationCheck(list)) {
            throw new IllegalArgumentException("번호에 중복이 있습니다.");
        }
    }

    private boolean numberRangeCheck(List<Integer> list) {
        return list.stream().anyMatch(value -> value < START_NUMBER || value > END_NUMBER);
    }

    private boolean duplicationCheck(List<Integer> list) {
        return list.stream().distinct().count() != list.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
