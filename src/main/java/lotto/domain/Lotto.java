package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final int ONE_GAME_PRICE = 1000;
    private final List<List<Integer>> tickets = new ArrayList<>();

    public Lotto(final int price) {
        for (int i = 0; i < buyTicketNumber(price); i++) {
            tickets.add(new ArrayList<>());
        }
    }

    private int buyTicketNumber(final int price) {
        return (price / ONE_GAME_PRICE);
    }

    public int getTicketNum() {
        return tickets.size();
    }

}
