package lotto;

public class LottoSheet {
    public static final int LOTTO_SHEET_PRICE = 1_000;
    public static int calculateSheetCount(int money) {
        return money / LOTTO_SHEET_PRICE;
    }
}
