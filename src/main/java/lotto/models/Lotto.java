package lotto.models;


import java.util.*;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    protected Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(LottoNumbers.of(numbers));
    }

    public static Lotto of(String numbers) {
        return new Lotto(LottoNumbers.of(numbers));
    }
}
