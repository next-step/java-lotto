package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos = new ArrayList<>();
    private final int buyMoney;

    public LottoStore(String money, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        validMoney(money);
        buyMoney = Integer.parseInt(money);
        isPossibleBuyLotto(buyMoney);
        buyLottos(buyMoney / 1000);
    }

    private void validMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException("돈은 null이면 안됩니다.");
        }
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isPossibleBuyLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("돈은 1000원 이상이어야 합니다.");
        }
    }

    private void buyLottos(int availablePurchaseCount) {
        for (int i = 0; i < availablePurchaseCount; i++) {
            lottos.add(new Lotto(numberGenerator));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getBuyMoney() {
        return buyMoney;
    }
}
