package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void addLottoTicket(Lotto lotto){
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
