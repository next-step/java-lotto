package lottoAuto.vo;

import lottoAuto.service.Rank;

public class LottoResultVo {
    private Rank rank;
    private int count;

    public LottoResultVo(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

}
