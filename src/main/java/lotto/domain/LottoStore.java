package lotto.domain;

import lotto.utils.LottoHelper;

public class LottoStore {

    private final LottoMachine lottoMachine;

    public static final int LOTTO_GAME_FEE = 1_000;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket buyTickets(LottoRequest request) {
        if (request.getMoney().isLess(LOTTO_GAME_FEE)) {
            throw new IllegalArgumentException(String.format("금액이 부족합니다. \n 로또 한개당 가격은 %d원입니다.", LOTTO_GAME_FEE));
        }
        return createLottos(request);
    }

    private LottoTicket createLottos(LottoRequest request) {
        return lottoMachine.createLotto(request);
    }

    public LottoResult checkWinningLotto(WInningLottoRequest wInningLottoRequest, LottoTicket lottoTicket) {
        return check(createWInningLotto(wInningLottoRequest), lottoTicket);
    }

    private LottoResult check(WInningLotto winningLotto, LottoTicket lottoTicket) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = winningLotto.howManyMatchBall(lotto);
            boolean bonusCount = winningLotto.hasBonusBall(lotto);
            lottoResult.addResult(LottoPrize.findPrize(matchCount, bonusCount));
        }
        return lottoResult;
    }

    private WInningLotto createWInningLotto(WInningLottoRequest wInningLottoRequest) {
        return new WInningLotto(Lotto.ofManual(LottoHelper.convertToBalls(wInningLottoRequest.getLottoNumbers())), LottoHelper.convertToBall(wInningLottoRequest.getBonusNumber()));
    }
}
