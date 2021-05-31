package lotto.domain;

import lotto.dto.PurchaseMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class LottoGames {

    private List<LottoGame> values;

    public LottoGames(List<LottoGame> values) {
        this.values = values;
    }

    public static LottoGames purchaseAuto(PurchaseMoney purchaseMoney) {
        validateEnoughMoney(purchaseMoney);
        int count = calculateBuyableCount(purchaseMoney);

        List<LottoGame> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(LottoGame.createAuto());
        }

        return new LottoGames(values);
    }

    public LottoGame get(int index) {
        return values.get(index);
    }

    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGames that = (LottoGames) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    private static void validateEnoughMoney(PurchaseMoney purchaseMoney) {
        LottoPrice.isEnoughMoney(purchaseMoney);
    }

    private static int calculateBuyableCount(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getValue() / LOTTO_PRICE;
    }

    public LottoGames merge(LottoGames otherLottoGames) {
        this.values.addAll(otherLottoGames.values);
        return this;
    }
}
