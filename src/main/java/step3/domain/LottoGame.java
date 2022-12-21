package step3.domain;

public class LottoGame {

    private Lottos buyLottos;
    private WinningLotto winningLotto;
    private LottoResult lottoResult = new LottoResult();


    public LottoGame(Lottos buylottos, WinningLotto winningLotto) {
        this.buyLottos = buylottos;
        this.winningLotto = winningLotto;
    }

    public LottoResult match() {
        for (Lotto lotto : buyLottos.getLottoList()) {
            int matchCount = lotto.matchCount(winningLotto);
            boolean matchBonus = lotto.matchBonus(winningLotto);

            lottoResult.matchGrade(matchCount, matchBonus);
        }
        lottoResult.calculateRevenue(buyLottos.buyCount());
        return lottoResult;
    }

}
