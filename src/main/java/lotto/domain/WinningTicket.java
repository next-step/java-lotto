package lotto.domain;

import java.util.List;

public class WinningTicket extends LottoTicket {

    private final LottoNumber bonusNumber;
    private final List<Rank> checkBonusRanks;

    public WinningTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
        this.checkBonusRanks = Rank.getHasBonusBallRanks();
    }

    public static WinningTicket of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningTicket(parseLottoNumbers(numbers), new LottoNumber(bonusNumber));
    }

    public boolean isMatchBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.isContainNumber(bonusNumber);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int countOfMatch = this.getCountOfMatch(lottoTicket);
        boolean isMatchBonusBall = checkMatchBonusBall(countOfMatch) && isMatchBonusBall(lottoTicket);

        return Rank.getRankByCountOfMatchAndBonusBall(countOfMatch, isMatchBonusBall);
    }

    private boolean checkMatchBonusBall(int countOfMatch) {
        return checkBonusRanks.stream()
                .anyMatch(rank -> rank.getCountOfMatch() == countOfMatch);
    }
}
