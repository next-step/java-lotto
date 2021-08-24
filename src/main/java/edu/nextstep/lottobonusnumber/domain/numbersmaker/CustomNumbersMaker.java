package edu.nextstep.lottobonusnumber.domain.numbersmaker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomNumbersMaker implements NumbersMaker{

    private final List<Integer> numbers;

    public CustomNumbersMaker(String winningNumbers) {
        this.numbers = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> create() {
        return numbers;
    }
}
