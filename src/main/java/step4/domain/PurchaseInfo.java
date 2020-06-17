package step4.domain;

/*
 * Lotto
 * Money
 * ver. 1.0
 * 2020.05.31
 */
public class PurchaseInfo {

    private int payedMoney;
    private int selfChooseCount;
    private int lottoPrice;
    private int boughtLottoCount;

    public PurchaseInfo(String input, String selfChooseCount, int lottoPrice) {
        Number.checkNumber(input);
        Number.checkNumber(selfChooseCount);
        Number.checkNotNumber(input);
        Number.checkNotNumber(selfChooseCount);
        this.payedMoney = Integer.parseInt(input);
        this.selfChooseCount = Integer.parseInt(selfChooseCount);
        this.lottoPrice = lottoPrice;
    }

    public int getBoughtLottoCount() {
        return calculateGameCountByPayMoney();
    }

    public int getSelfChooseCount() {
        return selfChooseCount;
    }

    // pay
    private int calculateGameCountByPayMoney() {
        boughtLottoCount = payedMoney / lottoPrice;
        boughtLottoCount -= selfChooseCount;
        if (boughtLottoCount < 1) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return boughtLottoCount;
    }

}
