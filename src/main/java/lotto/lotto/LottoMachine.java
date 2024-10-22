package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final static int MIN_PRICE = 1000;

    private final int price;
    private final LottoGeneratorStrategy lottoGeneratorStrategy;
    private final int executeIdx;
    private final List<Lotto> lottos;

    public LottoMachine(final int price, LottoGeneratorStrategy lottoGeneratorStrategy) {
        validatePrice(price);
        this.price = price;
        this.executeIdx = getExecuteIdx();
        this.lottos = new ArrayList<>();
        this.lottoGeneratorStrategy = lottoGeneratorStrategy;
    }

    /**
     * 로또 금액만큼 생성
     * */
    public void createLottos() {
        for (int i = 0; i < executeIdx; i++) {
            Lotto lotto = lottoGeneratorStrategy.generateLotto();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getExecuteIdx() {
        return price / 1000;
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("1000원 이상입니다.");
        }
    }
}
