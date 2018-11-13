package lotto.domain;

import lotto.domain.lottoMachine.LottoMachineFactory;
import lotto.utils.LottoHelper;

import java.util.List;

public class LottoStore {

    private final LottoMachineFactory lottoMchineFactory;

    public static final int LOTTO_GAME_FEE = 1000;

    public LottoStore(LottoMachineFactory lottoMchineFactory) {
        this.lottoMchineFactory = lottoMchineFactory;
    }

    public LottoTicket buyTickets(LottoRequest request) {
        Money won = request.getMoney();

        if (won.isLess(LOTTO_GAME_FEE)) {
            throw new IllegalArgumentException(String.format("금액이 부족합니다. \n 로또 한개당 가격은 %d원입니다.", LOTTO_GAME_FEE));
        }
        
        LottoTicket tickets = new LottoTicket();
        // 수동 로또 생성
        tickets.addLotto(createLotto(Lotto.LottoType.MANUAL, request));
        // 자동 로또 생성
        tickets.addLotto(createLotto(Lotto.LottoType.AUTO, request));

        return tickets;
    }

    public LottoResult checkWinningLotto(WInningLottoRequest wInningLottoRequest, LottoTicket lottoTicket) {
        return check(createWInningLotto(wInningLottoRequest), lottoTicket);
    }

    private LottoResult check(WInningLotto winningLotto, LottoTicket lottoTicket) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTicket.getAllLotto()) {
            int matchCount = winningLotto.howManyMatchBall(lotto);
            boolean bonusCount = winningLotto.hasBonusBall(lotto);
            lottoResult.addResult(LottoPrize.findPrize(matchCount, bonusCount));
        }

        return lottoResult;
    }

    private WInningLotto createWInningLotto(WInningLottoRequest wInningLottoRequest) {
        return new WInningLotto(new Lotto(Lotto.LottoType.WINNING, LottoHelper.convertToBalls(wInningLottoRequest.getLottoNumbers())), LottoHelper.convertToBall(wInningLottoRequest.getBonusNumber()));
    }

    private List<Lotto> createLotto(Lotto.LottoType type, LottoRequest request) {
        return lottoMchineFactory.createLottoMachine(type).createLotto(request);
    }
}
