package step4.domain;

import step4.domain.generator.LottoGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LottoGame {
    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);

    private LottoCount lottoCount;
    private Lottos lottos;

    public LottoGame(BigDecimal amount, int manualCount) {
        lottoCount = new LottoCount(count(amount), manualCount);
        lottos = new Lottos(new ArrayList<>());
    }

    public LottoResult lottoResultMap(String lastWinningNumber, int bonusNumber) {
        String[] winningNumbers = lastWinningNumber.split(",");
        for (String number : winningNumbers) {
            lottos.checkWinningLotto(new LottoNumber(Integer.parseInt(number)), new LottoNumber(bonusNumber));
        }
        return lottos.winningLottoResult();
    }

    public void buyLotto(LottoGenerator lottoGenerator, String... varargs) {
        this.lottos.getLottos().add(lottoGenerator.generate(varargs));
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public Lottos getLottos() {
        return lottos;
    }

    private int count(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE).intValue();
    }


}
