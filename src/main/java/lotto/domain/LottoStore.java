package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Numbers;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    List<BasicLotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator, int money, List<Numbers> manualLottoNumbers) {
        this.lottoGenerator = lottoGenerator;
        lottos = new ArrayList<>();
        int tryCount = convertMoneyToTryCount(money) - manualLottoNumbers.size();
        addManualLottos(manualLottoNumbers);
        buyLottos(tryCount);
    }

    private void addManualLottos(List<Numbers> manualLottoNumbers) {
        manualLottoNumbers.forEach(numbers -> lottos.add(new BasicLotto(numbers)));
    }

    private void buyLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new BasicLotto(this.lottoGenerator.generate()));
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
