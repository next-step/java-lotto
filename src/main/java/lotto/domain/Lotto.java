package lotto.domain;

import lotto.dto.WinningInfoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        List<Integer> numbersRange = new ArrayList<>();
        for (int number = 1; number <= 45; number++) {
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

    public WinningInfoDTO winningInfo(String numbers) {
        int correctCount = correctCount(numbers);

        int winningAmount = Arrays.stream(WinningEnum.values())
                .filter(winningEnum -> winningEnum.getCorrectCount() == correctCount)
                .mapToInt(WinningEnum::getWinningAmount)
                .findFirst()
                .orElse(0);

        return new WinningInfoDTO(correctCount, winningAmount);
    }

    private int correctCount(String numbers) {
        return Parser.numbersParsing(numbers)
                .stream()
                .filter(value -> this.numbers.contains(value))
                .collect(Collectors.toList())
                .size();
    }


    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
