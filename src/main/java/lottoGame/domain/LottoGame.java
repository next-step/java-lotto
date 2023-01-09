package lottoGame.domain;

public class LottoGame {

    private Lottos buyLottos;
    private WinningLotto winningLotto;

    public LottoGame(Lottos buylottos, WinningLotto winningLotto) {
        this.buyLottos = buylottos;
        this.winningLotto = winningLotto;
    }

    public LottoResult match() {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : buyLottos.getLottoList()) {
            int matchCount = lotto.matchCount(winningLotto);
            boolean matchBonus = lotto.matchBonus(winningLotto);
            lottoResult.matchGrade(matchCount, matchBonus);
        }
        lottoResult.calculateRevenue(buyLottos.buyCount());
        return lottoResult;
    }
}
