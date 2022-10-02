package lotto.domain;

public class PurchaseMoney {
    private final int money;
    private final int count;

    public PurchaseMoney(int money) {
        int result = money / Lotto.PRICE;
        validateMoney(money, result);
        this.money = money;
        this.count = result;
    }

    public int getLottoCount() {
        return count;
    }

    private static void validateMoney(int money, int count) {
        if (count * Lotto.PRICE != money) {
            throw new IllegalArgumentException("거스름돈은 반환이 불가능합니다. 로또는 " + Lotto.PRICE + "원 입니다.");
        }
    }

    public float getEarningRate(LottoResult result) {

        int totalPrize = (result.getFirstCount() * LottoResult.FIRST_PRIZE)
                + (result.getSecondCount() * LottoResult.SECOND_PRIZE)
                + (result.getThirdCount() * LottoResult.THIRD_PRIZE)
                + (result.getFourthCount() * LottoResult.FOURTH_PRIZE);

        return  totalPrize / (float) (this.getLottoCount() * Lotto.PRICE);
    }
}
