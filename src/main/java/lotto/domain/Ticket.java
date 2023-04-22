package lotto.domain;

import java.util.List;

public class Ticket {
    public Ticket(List<Integer> purchaseGame) {
        validate(purchaseGame);
    }

    private void validate(List<Integer> purchaseGame) {
        throw new RuntimeException("숫자는 6개 이여야함");
    }
}
