package step3.domain;

public class ControlLottoGame {

    public BuyInfo startLotto(int count, String[] manulaLottoNumbers) {
        return new BuyInfo(count, manulaLottoNumbers);
    }

    public Ranks makeRankListByBuyLotto(WinLotto winLotto, BuyInfo buyInfo) {
        Ranks ranks = new Ranks(winLotto, buyInfo);
        return ranks;
    }
}
