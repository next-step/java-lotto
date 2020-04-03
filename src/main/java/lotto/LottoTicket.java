package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int MIN_PURCHASE_AMOUNT = LottoRule.MIN_PURCHASE_AMOUNT.getValue();

    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int totalPurchaseAmount() {
        return this.lottoNumbers.size() * MIN_PURCHASE_AMOUNT;
    }

    public String purchaseLottoNumbers() {
        String result = "";
        for (LottoNumbers lottoNumbers : this.lottoNumbers) {
            result += lottoNumbers.getNumbers().stream().map(LottoNo::getNo).collect(Collectors.toList())
                      + "\n";
        }

        return result;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
