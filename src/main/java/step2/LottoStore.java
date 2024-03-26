package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private static final int NO_MANUAL_LOTTO = 0;
    private final NumberGenerator numberGenerator;
    private Lottos lottos;
    private final int buyMoney;
    private int autoLottoCount;
    private int manualLottoCount;

    public LottoStore(String money, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        validMoney(money);
        buyMoney = Integer.parseInt(money);
        isPossibleBuyLotto(buyMoney, NO_MANUAL_LOTTO);
        buyAutoLottos(buyMoney / LOTTO_PRICE);
    }

    public LottoStore(String money, NumberGenerator numberGenerator, List<String> manualLottoNumbers) {
        this.numberGenerator = numberGenerator;
        validMoney(money);
        buyMoney = Integer.parseInt(money);
        manualLottoCount = manualLottoNumbers.size();
        isPossibleBuyLotto(buyMoney, manualLottoCount);
        buyManualLottos(manualLottoNumbers);
        buyAutoLottos((buyMoney / LOTTO_PRICE) - manualLottoCount);
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
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈은 1000원 이상이어야 합니다.");
        }

        if (manualLottoCount * LOTTO_PRICE > money) {
            throw new IllegalArgumentException("해당 돈으로는 원하는 만큼의 수동 로또를 구매할 수 없습니다.");
        }
    }

    private void buyManualLottos(List<String> manualLottoNumbers) {
        Lottos manualLottos = Lottos.buyManualLottos(manualLottoNumbers, numberGenerator);
        lottos = manualLottos;
    }

    private void buyAutoLottos(int availablePurchaseCount) {
        autoLottoCount = availablePurchaseCount;
        Lottos autoLottos = Lottos.buyLottos(availablePurchaseCount, numberGenerator);
        lottos = mergeLottos(lottos, autoLottos);
    }

    private Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> mergedLottoList = new ArrayList<>();
        if (manualLottos != null) {
            mergedLottoList.addAll(manualLottos.getLottos());
        }
        if (autoLottos != null) {
            mergedLottoList.addAll(autoLottos.getLottos());
        }
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
