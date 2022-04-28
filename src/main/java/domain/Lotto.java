package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> compare(Lotto lotto) {
        return this.lottoNumbers
                .stream()
                .filter(lotto.lottoNumbers::contains)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
