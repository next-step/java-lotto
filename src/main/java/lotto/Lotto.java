package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.LottoNumber.LOTTO_NUMBERS;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int DEFAULT_PRICE = 1000;

    private final int price = DEFAULT_PRICE;
    private final List<LottoNumber> lottoNumbers;

    public static Lotto create() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.subList(0, 6));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 이어야 합니다.");
        }
    }

    public int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
