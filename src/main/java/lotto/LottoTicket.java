package lotto;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;
    private List<Rank> lottoRankList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Rank> getLottoRankList() {
        return lottoRankList;
    }

    public void setLottoRankList(List<Rank> lottoRankList) {
        this.lottoRankList = lottoRankList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
