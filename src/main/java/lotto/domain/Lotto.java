package lotto.domain;

import lotto.dto.WinningInfoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);
    }
    public Lotto(String numbers) {
        this.numbers = new ArrayList<>(Parser.numbersParsing(numbers));
    }

    public List<Integer> purchasing() {
        List<Integer> game = numbers.subList(0, 6);
        Collections.sort(game);
        return game;
    }

    public WinningInfoDTO winningInfo(String numbers) {
        int correctCount = correctCount(numbers);

        if (correctCount == 6) {
            return new WinningInfoDTO(1, 2000000000);
        }

        if (correctCount == 5) {
            return new WinningInfoDTO(3, 1500000);
        }

        if (correctCount == 4) {
            return new WinningInfoDTO(4, 50000);
        }

        if (correctCount == 3) {
            return new WinningInfoDTO(5, 5000);
        }

        return null;
    }

    private int correctCount(String numbers) {
        List<Integer> game = purchasing();

        return Parser.numbersParsing(numbers)
                .stream()
                .filter(value -> game.contains(value))
                .collect(Collectors.toList())
                .size();
    }
}
