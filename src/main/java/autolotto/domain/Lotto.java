package autolotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        if (lottoNumbers == null) {
            return "[]";
        }
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
