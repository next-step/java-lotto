package lotto.model;

public enum LottoResult {
    FIRST("1등", 5_000, ),
    SECOND("2등", 50_000, ),
    THIRD("3등", 1_500_000, ),
    FOURTH("4등", 30_000_000, ),
    FIFTH("5등", 2_000_000_000, );

    private final String place;
    private final int price;
    private final int number;

    LottoResult(String place, int price, int number) {
        this.place = place;
        this.price = price;
        this.number = number;
    }
}
