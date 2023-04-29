package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String SPLIT_REGEX = ", ";
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(String lottoNumber) {
        lottoNumbers.addAll(split(lottoNumber));
    }

    private List<Integer> split(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_REGEX)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int findMatchCount(String firstLottoNumber) {
        List<Integer> numbers = split(firstLottoNumber);
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        return Objects.equals(this.lottoNumbers, o);
    }

}
