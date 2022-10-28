package lotto.backend.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> values;

    public LottoTickets(final List<LottoTicket> value) {
        this.values = new ArrayList<>(value);
    }

    public int size() {
        return values.size();
    }

    public int orderAmount() {
        return size() * LottoTicket.PRICE_PER_LOTTO;
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(this.values);
    }
}
