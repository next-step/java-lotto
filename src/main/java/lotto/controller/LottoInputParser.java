package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lotto.LottoNumberGenerator;
import lotto.data.LottoNumbers;
import lotto.input.InputReader;

public class LottoInputParser {
    public static List<Integer> getWinningInput(InputReader inputReader) {
        List<String> inputNumbers = Arrays.asList(inputReader.readLine("당첨번호 입력: ").split(", "));

        if (inputNumbers.size() != 6) {
            throw new RuntimeException();
        }

        return inputNumbers.stream()
                           .map(Integer::valueOf)
                           .collect(Collectors.toList());
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
