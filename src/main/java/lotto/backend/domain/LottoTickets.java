package lotto.backend.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> values;

    public LottoTickets() {
        this.values = new ArrayList<>();
    }

    public void add(List<LottoTicket> lottoTickets) {
        values.addAll(new ArrayList<>(lottoTickets));
    }

    public int countOfAutoLotto() {
        return (int) values.stream()
                .filter(LottoTicket::isAutoType)
                .count();
    }

    public int countOfCustomLotto() {
        return values.size() - countOfAutoLotto();
    }

    public int size() {
        return values.size();
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(this.values);
    }


}
