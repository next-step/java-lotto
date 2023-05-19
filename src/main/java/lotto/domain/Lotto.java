package lotto.domain;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX = "로또 번호는 6개의 숫자로 구성되어야 합니다.";
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers();
    }

    public void validateLottoNumbers() {
        if (isLottoNumbersSizeIsSix()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX);
        }
    }

    private boolean isLottoNumbersSizeIsSix() {
        return lottoNumbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public static int findPurchaseCount(int purchaseAmount) {
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
