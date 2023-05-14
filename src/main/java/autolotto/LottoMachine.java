package autolotto;

import autolotto.lotto.Lotto;
import autolotto.lotto.LottoGenerator;

import java.util.List;

public class LottoMachine {
    private final static int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;
    private final int inputMoney;

    public LottoMachine(LottoGenerator lottoGenerator, int inputMoney) {
        this.lottoGenerator = lottoGenerator;
        this.inputMoney = inputMoney;
    }

    public List<Lotto> lotteries() {
        return lottoGenerator.generateMultipleLotto(calculateLottoCount());
    }

    private int calculateLottoCount() {
        return inputMoney / LOTTO_PRICE;
    }
}
