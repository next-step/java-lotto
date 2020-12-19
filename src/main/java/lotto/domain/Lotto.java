package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(String input) {
        String[] parts = input.split(",");

        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String part : parts) {
            lottoNumbers.add(LottoNumber.of(part));
        }

        return new Lotto(lottoNumbers);
    }

    public int[] toArray() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::getValue)
                .toArray();
    }
}
