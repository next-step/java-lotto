package step2;

import java.util.ArrayList;
import java.util.List;

import static step2.LottoUtil.LOTTO_PRICE;

public class Ticket {
    private static final String AMOUNT_EXCEPTION = "로또는 1000원단위로 구매할 수 있습니다.";
    private List<Game> games;

    public Ticket(int amount) {
        games = new ArrayList<>();
        int gameCount = checkoutGames(amount);
        for (int count = 0; count < gameCount; count++) {
            games.add(new Game());
        }

    }

    public List<Game> getGames() {
        return games;
    }

    public int getGameCount() {
        return games.size();
    }

    private int checkoutGames(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount / LOTTO_PRICE < 1) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
        return amount / LOTTO_PRICE;
    }

}
