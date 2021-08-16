package step3.domain;

import java.util.List;

public class LottoTicket {
    private List<List<Integer>> bundle;

    public LottoTicket(List<List<Integer>> bundle) {
        this.bundle = bundle;
    }

    public List<List<Integer>> getBundle() {
        return bundle;
    }
}
