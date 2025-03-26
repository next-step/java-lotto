package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoTicket {

    private final int count;

    private List<LottoRow> lottoRowList = new ArrayList<>();

    public LottoTicket(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
