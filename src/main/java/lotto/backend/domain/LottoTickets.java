package lotto.backend.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> values;

    public LottoTickets(final List<LottoTicket> value) {
        this.values = new ArrayList<>(value);
    }

    public int size() {
        return values.size();
    }

    public String print(String delimiter) {
        return values.stream()
                .map(LottoTicket::print)
                .collect(Collectors.joining(delimiter));
    }

    public int orderAmount() {
        return values.stream()
                .mapToInt(LottoTicket::price)
                .sum();
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(this.values);
    }
}
