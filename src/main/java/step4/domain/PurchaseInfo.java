package step4.domain;

/*
 * Lotto
 * Money
 * ver. 1.0
 * 2020.05.31
 */
public class PurchaseInfo {

    private int payedMoney;
    private int lottoPrice;
    private int boughtLottoCount;

    public PurchaseInfo(String input, int lottoPrice) {
        Number.checkNumber(input);
        Number.checkNotNumber(input);
        this.payedMoney = Integer.parseInt(input);
        this.lottoPrice = lottoPrice;
    }

    public int getBoughtLottoCount() {
        return calculateGameCountByPayMoney();
    }

    // pay
    private int calculateGameCountByPayMoney() {
        boughtLottoCount = payedMoney / lottoPrice;
        if (boughtLottoCount < 1) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return boughtLottoCount;
    }

}
