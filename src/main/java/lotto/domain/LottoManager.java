package lotto.domain;

import lotto.dto.LottoStatisticsDto;

public class LottoManager {

    public static final int LOTTO_PRICE = 1000;

    private LottoTickets lottoTickets;
    private int lottoCount;

    public void createLottoNumbers(int purchaseAmount) {
        lottoCount = purchaseAmount / LOTTO_PRICE;
        createLottoNumbers();
    }

    private void createLottoNumbers() {
        lottoTickets = new LottoTickets(lottoCount, new RandomNumberCreation());
    }

    public LottoStatisticsDto calculateLottoStatistics(WinningTicket winningTicket) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        return new LottoStatisticsDto(
                lottoStatistics.calculateMatchingCounts(lottoTickets, winningTicket),
                lottoStatistics.calculateGrossRateOfEarnings(lottoCount * LOTTO_PRICE)
        );
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public LottoTickets getLottoNumbers() {
        return lottoTickets;
    }
}
