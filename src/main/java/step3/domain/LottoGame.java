package step3.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private LottoNumberGenerator lottoNumberGenerator;
    private LottoNumbers lottoNumbers;

    public LottoGame(BigDecimal amount, LottoNumberGenerator generator) {
        lottoNumberGenerator = generator;
        lottoNumbers = buyLottoNumbers(amount);
    }

    public LottoResult lottoResultMap(String lastWinningNumber) {
        String[] winningNumbers = lastWinningNumber.split(",");
        for (String number : winningNumbers) {
            lottoNumbers.checkWinningLotto(new LottoNumber(Integer.parseInt(number)));
        }
        return new LottoResult(lottoNumbers.winningResultMap());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private LottoNumbers buyLottoNumbers(BigDecimal amount) {
        List<Lotto> numbers = new ArrayList<>();

        for (int i=0; i<lottoCount(amount); i++) {
            numbers.add(buyLottoNumber());
        }

        return new LottoNumbers(numbers);
    }

    private int lottoCount(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE).intValue();
    }

    Lotto buyLottoNumber() {
        return lottoNumberGenerator.generate();
    }
}
