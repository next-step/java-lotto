package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Numbers;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    List<BasicLotto> lottos;
    private LottoGenerator manualLottoGenerator;
    private LottoGenerator randomLottoGenerator;

    public LottoStore(LottoGenerator manualLottoGenerator, LottoGenerator randomLottoGenerator, int money, List<Numbers> manualLottoNumbers) {
        this.manualLottoGenerator = manualLottoGenerator;
        this.randomLottoGenerator = randomLottoGenerator;
        lottos = new ArrayList<>();
        int tryCount = convertMoneyToTryCount(money) - manualLottoNumbers.size();
        buyManualLottos(manualLottoNumbers);
        buyRandomLottos(tryCount);
    }

    private void buyManualLottos(List<Numbers> manualLottoNumbers) {
        manualLottoNumbers.forEach(numbers -> lottos.add(manualLottoGenerator.generate(numbers)));
    }

    private void buyRandomLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(this.randomLottoGenerator.generate());
        }
    }

    private int convertMoneyToTryCount(int money) {
        if (money < 0)
            throw new IllegalArgumentException();

        return money / LOTTO_PRICE;
    }

    public List<BasicLotto> getLottos() {
        return lottos;
    }
}
