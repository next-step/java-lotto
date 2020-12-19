package lotto.domain;

public class LottoDrawMachine {

    private final LottoResult lottoResult;

    public LottoDrawMachine() {
        lottoResult = LottoResult.getInstance();
    }

    public LottoResult drawLottoResult(WinningLotto winningLotto, PublishedLottoTicket publishedLottoTicket) {
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);
        return lottoResult;
    }

}
