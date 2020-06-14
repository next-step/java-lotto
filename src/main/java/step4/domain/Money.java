package step4.domain;

/*
 * Lotto
 * Money
 * ver. 1.0
 * 2020.05.31
 */
public class Money {

    private Integer payedMoney;
    private Integer lottoPrice;
    private Integer boughtLottoCount;

    public Money(String input, Integer lottoPrice) {
        Number.checkNumber(input);
        Number.checkNotNumber(input);
        this.payedMoney = Integer.parseInt(input);
        this.lottoPrice = lottoPrice;
    }

    public Integer getBoughtLottoCount() {
        return calculateGameCountByPayMoney();
    }

    // pay
    private Integer calculateGameCountByPayMoney() {
        boughtLottoCount = payedMoney / lottoPrice;
        if (boughtLottoCount < 1) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        return boughtLottoCount;
    }

}
