package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final NumberGenerator numberGenerator;
    private Lottos lottos;
    private final int buyMoney;
    private int autoLottoCount;
    private int manualLottoCount;

    public LottoStore(String money, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        validMoney(money);
        buyMoney = Integer.parseInt(money);
        isPossibleBuyLotto(buyMoney, 0);
        buyLottos(buyMoney / 1000);
    }

    public LottoStore(String money, NumberGenerator numberGenerator, List<String> manualLottoNumbers) {
        this.numberGenerator = numberGenerator;
        validMoney(money);
        buyMoney = Integer.parseInt(money);

        manualLottoCount = manualLottoNumbers.size();
        isPossibleBuyLotto(buyMoney, manualLottoCount);

        Lottos manualLottos = Lottos.buyManualLottos(manualLottoNumbers, numberGenerator);
        autoLottoCount = (buyMoney / 1000) - manualLottoCount;
        Lottos autoLottos = Lottos.buyLottos(autoLottoCount, numberGenerator);

        lottos = mergeLottos(manualLottos, autoLottos);
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

    private void isPossibleBuyLotto(int money, int manualLottoCount) {
        if (money < 1000) {
            throw new IllegalArgumentException("돈은 1000원 이상이어야 합니다.");
        }

        if (manualLottoCount * 1000 > money) {
            throw new IllegalArgumentException("해당 돈으로는 원하는 만큼의 수동 로또를 구매할 수 없습니다.");
        }
    }

    private void buyLottos(int availablePurchaseCount) {
        lottos = Lottos.buyLottos(availablePurchaseCount, numberGenerator);
    }

    private Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> mergedLottoList = new ArrayList<>();
        mergedLottoList.addAll(manualLottos.getLottos());
        mergedLottoList.addAll(autoLottos.getLottos());
        return new Lottos(mergedLottoList);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }
}
