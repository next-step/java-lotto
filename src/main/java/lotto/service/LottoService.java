package lotto.service;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.WinningResult;
import lotto.domain.WinnerLottoTicket;
import lotto.domain.dto.ResultDto;
import lotto.domain.dto.WinningLottoTicketDto;
import lotto.exception.MinimumAmountException;
import lotto.util.AutoLottoNumberUtils;

public class LottoService {

    private static final double DEFAULT_PRIZE_MONEY = 0d;
    private static final double DECIMAL_POINT = 100d;
    private static final long TICKET_PRICE = 1000l;
    private static final int MINIMUM_COUNT = 1;

    private static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
    }

    public LottoTickets autoTickets(int money) {
        int count = getCount(money);
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < count; i++) {
            lottoTickets = lottoTickets.add(AutoLottoNumberUtils.getAutoLottoNumber());
        }
        return lottoTickets;
    }

    public ResultDto winningResult(WinningLottoTicketDto dto) {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.from(dto.getWinnerLottoTicket());
        List<Long> winningResult = winnerLottoTicket.winnerCount(dto.getLottoTickets());
        WinningResult resultRank = new WinningResult();
        resultRank.updateRank(winningResult);
        return ResultDto.of(resultRank, mathYield(resultRank.getMoney(), resultRank.getPrizeMoney()));
    }

    private int getCount(int money) {
        int count = (int) Math.floor(money / TICKET_PRICE);
        if (count < MINIMUM_COUNT) {
            throw new MinimumAmountException(TICKET_PRICE);
        }
        return count;
    }

    private Double mathYield(Double money, Double prizeMoney) {
        if (prizeMoney == DEFAULT_PRIZE_MONEY) {
            return DEFAULT_PRIZE_MONEY;
        }
        return Math.floor((prizeMoney / money) * DECIMAL_POINT) / DECIMAL_POINT;
    }

}
