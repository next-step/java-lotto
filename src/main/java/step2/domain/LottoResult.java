package step2.domain;

public enum LottoResult {
    MATCHED_3(3, 5000),
    MATCHED_4(4, 50000),
    MATCHED_5(5, 1500000),
    MATCHED_6(6, 2000000000),
    ;

    public final int numbersToBeMatched;
    public final int winningPrice;

    LottoResult(int numbersToBeMatched, int winningPrice) {
        this.numbersToBeMatched = numbersToBeMatched;
        this.winningPrice = winningPrice;
    }
}
