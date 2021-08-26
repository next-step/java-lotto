package edu.nextstep.lottobonusnumber.domain.numbersmaker;

import edu.nextstep.lottobonusnumber.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomNumbersMaker implements NumbersMaker{

    private final List<LottoNumber> numbers;

    public CustomNumbersMaker(String winningNumbers) {
        numbers = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> create() {
        return numbers;
    }
}
