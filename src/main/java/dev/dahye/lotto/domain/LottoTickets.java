package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int ZERO_VALUE = 0;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets autoIssued(int countOfLotto) {
        validateCountOfLotto(countOfLotto);
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            lottoTickets.add(LottoTicket.autoIssued());
        }

        return new LottoTickets(lottoTickets);
    }

    private static void validateCountOfLotto(int countOfLotto) {
        if (countOfLotto <= ZERO_VALUE) {
            throw new IllegalArgumentException("로또 티켓 생성 갯수가 유효하지 않습니다.");
        }
    }

    public static LottoTickets manualIssued(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<Rank> calculateWinningRate(LottoTicket winningTicket, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getCountOfMatch(winningTicket);
            boolean isMatchBonusNumber = lottoTicket.contains(bonusNumber);
            addWhenIsRanking(ranks, matchCount, isMatchBonusNumber);
        }

        return ranks;
    }

    private void addWhenIsRanking(List<Rank> ranks, int matchCount, boolean isMatchBonusNumber) {
        if (Rank.canRanking(matchCount, isMatchBonusNumber)) {
            ranks.add(Rank.valueOf(matchCount, isMatchBonusNumber));
        }
    }

    public int size() {
        return this.lottoTickets.size();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTickets);
    }
}
