package lotto.models;


import java.util.*;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(String numbers) {
        return new Lotto(LottoNumbers.of(numbers));
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(LottoNumbers.of(numbers));
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers();
    }
}
