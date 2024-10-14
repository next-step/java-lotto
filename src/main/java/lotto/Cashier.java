package lotto;

public class Cashier {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public int makeLottoGamePapers(int totalAmount) {
        return totalAmount / LOTTO_TICKET_PRICE;
    }
}
