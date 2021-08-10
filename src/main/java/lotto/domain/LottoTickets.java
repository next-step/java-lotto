package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTickets {

    private static final int BONUS_TARGET_MATCH_COUNT = 5;
    private static final int SECOND_PLACE_MATCH_COUNT = 6;

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

    private LottoRank findLottoRank(final LottoTicket lottoTicket,
                                    final List<Integer> winningNumbers,
                                    final int bonusNumber) {
        int matchLottoNumberCount = lottoTicket.matchLottoTicket(winningNumbers);
        if (matchLottoNumberCount != BONUS_TARGET_MATCH_COUNT) {
            return LottoRank.of(matchLottoNumberCount, false);
        }

        List<Integer> winningNumbersAndBonusNumber = cloneWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        if (isSecondPlaceLottoTicket(lottoTicket, winningNumbersAndBonusNumber)) {
            return LottoRank.SECOND_PLACE;
        }
        return LottoRank.of(matchLottoNumberCount, false);
    }

    private List<Integer> cloneWinningNumbersAndBonusNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        List<Integer> winningNumbersWithBonusNumber = new ArrayList<>(winningNumbers);
        winningNumbersWithBonusNumber.add(bonusNumber);
        return winningNumbersWithBonusNumber;
    }

    private boolean isSecondPlaceLottoTicket(final LottoTicket lottoTicket,
                                             final List<Integer> winningNumbersAndBonusNumber) {
        int matchBonusCount = lottoTicket.matchLottoTicket(winningNumbersAndBonusNumber);
        return matchBonusCount == SECOND_PLACE_MATCH_COUNT;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}