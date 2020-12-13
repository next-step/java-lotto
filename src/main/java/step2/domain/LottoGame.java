package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoGame() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public LottoNumbers buyLottoNumbers(BigDecimal amount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i=0; i<lottoCount(amount); i++) {
            lottoNumbers.add(buyLottoNumber());
        }

        return new LottoNumbers(lottoNumbers);
    }

    private int lottoCount(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE).intValue();
    }

    LottoNumber buyLottoNumber() {
        return lottoNumberGenerator.generate();
    }
}
