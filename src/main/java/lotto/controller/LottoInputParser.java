package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.LottoNumberGenerator;
import lotto.data.LottoNumbers;
import lotto.input.InputReader;

public class LottoInputParser {
    public static List<Integer> getMultipleNumberInput(InputReader inputReader, String comment) {
        List<String> inputNumbers = Arrays.asList(inputReader.readLine(comment).split(", "));

        if (inputNumbers.size() != 6) {
            throw new RuntimeException();
        }

        return inputNumbers.stream()
                           .map(Integer::valueOf)
                           .collect(Collectors.toList());
    }

    public static int getSingleNumberInput(InputReader inputReader, String comment) {
        int inputNumber = inputReader.readInt(comment);

        if (inputNumber < 0) {
            throw new RuntimeException();
        }

        return inputNumber;
    }

    public static int getBonus(InputReader inputReader, LottoNumbers winningNumbers) {
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
