package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    public LottoNumbers getLottoNumbers(String input) {
        return new LottoNumbers(getNumberListFromString(input));
    }

    public LottoNumbers getAutoLottoNumbers() {
        return new LottoNumbers(generateAutoNumbers());
    }

    public WinningNumbers getWinningNumbers(String input) {
        return new WinningNumbers(getNumberListFromString(input));
    }

    public BonusNumber getBonusNumber(int input) {
        return new BonusNumber(input);
    }

    private List<Integer> getNumberListFromString(String input) {
        return Arrays.stream(input.trim().replaceAll(" ", "")
                .split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<Integer> generateAutoNumbers() {
        List<Integer> source = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(source::add);
        Collections.shuffle(source);
        return source.stream().limit(6).collect(Collectors.toList());
    }
}
