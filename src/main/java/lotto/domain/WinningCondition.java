package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningCondition {

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningCondition(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningCondition of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningCondition(LottoTicket.of(numbers), new LottoNumber(bonusNumber));
    }

    public boolean isMatchBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.isContainNumber(bonusNumber);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int countOfMatch = winningTicket.getCountOfMatch(lottoTicket);
        boolean isMatchBonusBall = checkMatchBonusBall(countOfMatch) && isMatchBonusBall(lottoTicket);

        return Rank.getRankByCountOfMatchAndBonusBall(countOfMatch, isMatchBonusBall);
    }

    private boolean checkMatchBonusBall(int countOfMatch) {
        return Arrays.stream(Rank.values())
                .anyMatch(rank -> rank.getCountOfMatch() == countOfMatch);
    }
}
