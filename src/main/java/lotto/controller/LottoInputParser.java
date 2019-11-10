package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.LottoNumberGenerator;
import lotto.data.LottoNumbers;
import lotto.input.InputReader;

public class LottoInputParser {
    private static final int NUMBER_MIN_THRESHOLD = 0;

    public static List<Integer> parseMultipleNumberInput(InputReader inputReader, String comment) {
        List<String> inputNumbers = Arrays.asList(inputReader.readLine(comment).split(", "));

        if (inputNumbers.size() != 6) {
            throw new RuntimeException();
        }

        return inputNumbers.stream()
                           .map(Integer::valueOf)
                           .collect(Collectors.toList());
    }

    public static int parseSingleNumberInput(InputReader inputReader, String comment) {
        int inputNumber = inputReader.readInt(comment);

        if (inputNumber < NUMBER_MIN_THRESHOLD) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    public static int parseBonus(InputReader inputReader, LottoNumbers winningNumbers) {
        int bonus = inputReader.readInt("보너스 번호를 입력해주세요");

        if (bonus < LottoNumberGenerator.MIN_RANGE_NUM || bonus > LottoNumberGenerator.MAX_RANGE_NUM) {
            throw new IllegalArgumentException();
        }

        if (winningNumbers.isMatchBonus(bonus)) {
            throw new IllegalArgumentException();
        }

        return bonus;
    }
}
