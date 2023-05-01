package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String SPLIT_REGEX = ", ";
    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 숫자의 입력값은 6개로 이루어져야 합니다.";
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(String lottoNumber) {
        lottoNumbers.addAll(split(lottoNumber));
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers.addAll(lottoNumbers);
    }

    private List<Integer> split(String lottoNumber) {
        List<Integer> numbers = Arrays.stream(lottoNumber.split(SPLIT_REGEX)).map(Integer::parseInt).collect(Collectors.toList());
        lottoSizeCheck(numbers);
        return numbers;
    }

    public int findMatchCount(String firstLottoNumber) {
        List<Integer> numbers = split(firstLottoNumber);
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private void lottoSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalStateException(LOTTO_SIZE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        return Objects.equals(this.lottoNumbers, o);
    }

}
