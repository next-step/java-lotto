package lotto.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(lottoNumbers::add);
        Collections.shuffle(lottoNumbers);
        this.lottoNumbers = lottoNumbers.subList(0, 6);
    }

    public Lotto(String winningNumbers) {
        String[] winningNumberList = winningNumbers.replace(" ", "").split(",");
        this.lottoNumbers = Arrays.stream(winningNumberList).map(Integer::parseInt)
                                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
