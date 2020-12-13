package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private LottoNumberGenerator lottoNumberGenerator;
    private int count;

    public LottoGame(BigDecimal amount) {
        count = amount.divide(LOTTO_PRICE).intValue();
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public int getCount() {
        return count;
    }

    public LottoNumbers buyLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i=0; i<count; i++) {
            lottoNumbers.add(buyLottoNumber());
        }

        return new LottoNumbers(lottoNumbers);
    }

    LottoNumber buyLottoNumber() {
        return lottoNumberGenerator.generate();
    }
}
