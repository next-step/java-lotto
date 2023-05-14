package lotto.domain;

import java.util.List;

import static lotto.utils.LottoNumbersValidationUtils.validateLottoNumbers;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static int findPurchaseCount(int purchaseAmount) {
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
