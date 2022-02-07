package lotto.domain;

public class LottoRaffle {

    private final WinningLotto winningLotto;
    private final LottoResult lottoResult = new LottoResult();

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void raffle(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            compareLotto(lotto);
        }
    }

    public LottoResult getResult() {
        return lottoResult;
    }

    private void compareLotto(Lotto lotto) {
        final int count = lotto.match(winningLotto);
        boolean isBonusNumber = lotto.contains(winningLotto.getBonusNumber());
        if (count != 5) {
            isBonusNumber = false;
        }
        final String resultHash = LottoDescription.findLottoHash(count, isBonusNumber);
        lottoResult.upCount(resultHash);
    }
}
