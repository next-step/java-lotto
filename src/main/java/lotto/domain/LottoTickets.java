package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public void add(final LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public LottoStatistic matchLottoTickets(final List<Integer> winningNumbers) {
        List<LottoRank> lottoStatistic = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchingCount = lottoTicket.matchLottoTicket(winningNumbers);
            LottoRank lottoRank = LottoRank.of(matchingCount, false);
            lottoStatistic.add(lottoRank);
        }
        return new LottoStatistic(lottoStatistic);
    }

    public LottoStatistic matchLottoTickets(final List<Integer> winningNumbers, final int bonusNumber) {
        List<LottoRank> lottoStatistic = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = findLottoRank(lottoTicket, winningNumbers, bonusNumber);
            lottoStatistic.add(lottoRank);
        }
        return new LottoStatistic(lottoStatistic);
    }

    private LottoRank findLottoRank(final LottoTicket lottoTicket, final List<Integer> winningNumbers, final int bonusNumber) {
        int matchLottoNumberCount = lottoTicket.matchLottoTicket(winningNumbers);
        if (matchLottoNumberCount == 5) {
            List<Integer> winningNumbersWithBonusNumber = new ArrayList<>(winningNumbers);
            winningNumbersWithBonusNumber.add(bonusNumber);
            int matchBonusCount = lottoTicket.matchLottoTicket(winningNumbersWithBonusNumber);
            if (matchBonusCount == 6) {
                return LottoRank.SECOND_BONUS_PLACE;
            }
        }
        return LottoRank.of(matchLottoNumberCount, false);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}