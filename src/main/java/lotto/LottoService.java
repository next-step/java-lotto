package lotto;

public class LottoService {

    private static final int PRICE_PER_TICKET = 1000;
    private static final String NUMBER_REGEX = "\\d+";

    public static void start() {

    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_TICKET;
    }


}

