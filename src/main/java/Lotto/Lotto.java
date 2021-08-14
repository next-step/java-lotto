package Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final LotterNumbers lottoNumbers;

    public Lotto(LotterNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto of(LotterNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int compareNumbers(List<Integer> userNumbers) {

        return lottoNumbers.getLottoNumbers()
                .stream()
                .filter(number -> userNumbers.contains(number))
                .collect(Collectors.toList()).size();
    }

}
