package lotto.domain;

import lotto.utils.LottoHelper;

import java.util.List;

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

        return LottoTicket.builder()
                    .manualLottos(createManualLottos(request))
                    .autoLottos(createAutoLottos(request))
                    .build();

    }

    private List<Lotto> createAutoLottos(LottoRequest request) {
        return lottoMachine.createAutoLotto(request);
    }

    private List<Lotto> createManualLottos(LottoRequest request) {
        return lottoMachine.createManualLotto(request);
    }

    public LottoResult checkWinningLotto(WInningLottoRequest wInningLottoRequest, LottoTicket lottoTicket) {
        return check(createWInningLotto(wInningLottoRequest), lottoTicket);
    }

    private LottoResult check(WInningLotto winningLotto, LottoTicket lottoTicket) {
        LottoResult lottoResult = new LottoResult();
        checkLotto(winningLotto, lottoResult, lottoTicket.getAutoLottos());
        checkLotto(winningLotto, lottoResult, lottoTicket.getManualLottos());
        return lottoResult;
    }

    private void checkLotto(WInningLotto winningLotto, LottoResult lottoResult, List<Lotto> autoLottos) {
        for (Lotto lotto : autoLottos) {
            int matchCount = winningLotto.howManyMatchBall(lotto);
            boolean bonusCount = winningLotto.hasBonusBall(lotto);
            lottoResult.addResult(LottoPrize.findPrize(matchCount, bonusCount));
        }
    }

    private WInningLotto createWInningLotto(WInningLottoRequest wInningLottoRequest) {
        return new WInningLotto(new Lotto(LottoHelper.convertToBalls(wInningLottoRequest.getLottoNumbers())), LottoHelper.convertToBall(wInningLottoRequest.getBonusNumber()));
    }
}
