package lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int DEFAULT_PRICE = 1000;


    private final int price = DEFAULT_PRICE;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 이어야 합니다.");
        }
    }

    public int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }
}
