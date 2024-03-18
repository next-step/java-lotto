package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoStore(String money) {
        validNullMoney(money);
        isNumeric(money);
        int buyMoney = Integer.parseInt(money);
        isPossibleBuyLotto(buyMoney);
        buyLottos(buyMoney/1000);
    }

    private void validNullMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException("돈은 null이면 안됩니다.");
        }
    }

    private void isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 사칙연산 숫자 순으로 입력해주세요");
        }
    }

    private void isPossibleBuyLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("돈은 1000원 이상이어야 합니다.");
        }
    }

    private void buyLottos(int money) {
        for (int i = 0; i <money; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
