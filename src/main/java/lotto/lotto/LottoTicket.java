package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    List<Lotto> lottoList = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> tickets() {
        return lottoList;
    }
}
