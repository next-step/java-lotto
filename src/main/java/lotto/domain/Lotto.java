package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(String[] numbers) {
        return new Lotto(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Integer> getValue() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getMatchNumberCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::hasNumber)
                .mapToInt(Integer::intValue)
                .count();
    }

    public boolean hasNumber(int value) {
        return this.lottoNumbers.contains(value);
    }
}
