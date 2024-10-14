package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int PRICE_OF_LOTTO = 1000;

    private final List<Lotto> lottos = new ArrayList<Lotto>();

    public Lottos() {
    }

    public void buyLotto(int purchaseAmount, LottoGenerator lottoGenerator) {
        int lottoCount = calculateNumberOfLotto(purchaseAmount);
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(lottoGenerator.generateLottos());
        }
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public int calculateNumberOfLotto(int purchaseAmount) {
        checkIfCanPurchaseLotto(purchaseAmount);
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    private static void checkIfCanPurchaseLotto(int totalAmount) {
        if (totalAmount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("1000원 미만으론 살 수 없음");
        }
    }

    public String allPurchasedLottoNumber() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.lottoNumber() + "\n");
        }
        return sb.toString();
    }

    public Lotto getLotto(int number) {
        return lottos.get(number);
    }

}
