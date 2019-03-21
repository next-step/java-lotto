package lotto.domain;

import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Ticket;
import lotto.utils.LottoGenerator;

import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private LottoGenerator manualLottoGenerator;
    private LottoGenerator randomLottoGenerator;
    private int tryCount;

    public LottoStore(LottoGenerator manualLottoGenerator, LottoGenerator randomLottoGenerator, int money, List<Ticket> manualLottoNumbers) {
        this.manualLottoGenerator = manualLottoGenerator;
        this.randomLottoGenerator = randomLottoGenerator;
        tryCount = convertMoneyToTryCount(money) - manualLottoNumbers.size();
    }

    public LottoBundle buyManualLottos(List<Ticket> manualLottoNumbers) {
        LottoBundle lottoBundle = new LottoBundle();
        manualLottoNumbers.forEach(numbers -> lottoBundle.add(manualLottoGenerator.generate(numbers)));
        return lottoBundle;
    }

    public LottoBundle buyRandomLottos() {
        LottoBundle lottoBundle = new LottoBundle();
        for (int i = 0; i < this.tryCount; i++) {
            lottoBundle.add(this.randomLottoGenerator.generate());
        }
        return lottoBundle;
    }

    private int convertMoneyToTryCount(int money) {
        if (money < 0)
            throw new IllegalArgumentException();

        return money / LOTTO_PRICE;
    }
}
