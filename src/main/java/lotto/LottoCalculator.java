package lotto;

public class LottoCalculator {

    public static int getLottoCount(int money) {
        if(money < 1000) {
            throw new IllegalArgumentException("로또을 사려면 1000원 이상 있어야 합니다.");
        }
        return money / Lotto.LOTTO_PRICE;
    }

    public static double getRateOfReturn(int initMoney, int getMoney) {
        double rate = (double) getMoney / initMoney;
        return (Math.floor(rate * 100) / 100.0);
    }

}
