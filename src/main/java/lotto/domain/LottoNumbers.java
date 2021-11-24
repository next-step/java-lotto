package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers() {

    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers createAutoLottoNumbers() {
        List<Integer> defaultNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(defaultNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            randomNumbers.add(defaultNumbers.get(i));
        }
        lottoNumbers = randomNumbers.stream()
                .sorted().collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
