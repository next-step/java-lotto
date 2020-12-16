package step3.domain;

import step3.domain.generator.LottoAutoGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private LottoAutoGenerator lottoAutoGenerator;
    private Lottos lottos;

    public LottoGame(BigDecimal amount, LottoAutoGenerator generator) {
        lottoAutoGenerator = generator;
        lottos = buyLottoNumbers(amount);
    }

    public LottoResult lottoResultMap(String lastWinningNumber, int bonusNumber) {
        String[] winningNumbers = lastWinningNumber.split(",");
        for (String number : winningNumbers) {
            lottos.checkWinningLotto(new LottoNumber(Integer.parseInt(number)), new LottoNumber(bonusNumber));
        }
        return lottos.winningLottoResult();
    }

    public Lottos getLottoNumbers() {
        return lottos;
    }

    private Lottos buyLottoNumbers(BigDecimal amount) {
        List<Lotto> numbers = new ArrayList<>();

        for (int i=0; i<lottoCount(amount); i++) {
            numbers.add(buyLottoNumber());
        }

        return new Lottos(numbers);
    }

    private int lottoCount(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE).intValue();
    }

    Lotto buyLottoNumber() {
        return lottoAutoGenerator.generate();
    }
}
