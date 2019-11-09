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

    public static Optional<Integer> getBonus(InputReader inputReader, LottoNumbers winningNumbers) {
        Optional<Integer> bonus = inputReader.readInt("보너스 번호를 입력해주세요");

        bonus.ifPresent(num -> {
            if (num < LottoNumberGenerator.MIN_RANGE_NUM || num > LottoNumberGenerator.MAX_RANGE_NUM) {
                throw new IllegalArgumentException();
            }

            if (winningNumbers.isMatchBonus(num)) {
                throw new IllegalArgumentException();
            }
        });

        return bonus;
    }
}
