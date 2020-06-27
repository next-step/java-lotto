package step4.domain;

/*
 * Lotto
 * Money
 * ver. 1.0
 * 2020.05.31
 */
public class PurchaseInfo {

    public static final int LOTTO_PRICE = 1000;

    private int payedMoney;
    private int selfChooseCount;
    private int boughtLottoCount;

    public PurchaseInfo(String input, String selfChooseCount) {
        Number.checkNumber(input);
        Number.checkNumber(selfChooseCount);
        Number.checkNotNumber(input);
        Number.checkNotNumber(selfChooseCount);
        this.payedMoney = Integer.parseInt(input);
        this.selfChooseCount = Integer.parseInt(selfChooseCount);

    }

    public int getBoughtLottoCount() {
        return calculateGameCountByPayMoney();
    }

    public int getSelfChooseCount() {
        return selfChooseCount;
    }

    // pay
    private int calculateGameCountByPayMoney() {
        boughtLottoCount = payedMoney / LOTTO_PRICE;
        boughtLottoCount -= selfChooseCount;
        if (boughtLottoCount < 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return boughtLottoCount;
    }

}
