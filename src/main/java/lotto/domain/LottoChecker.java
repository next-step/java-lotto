package lotto.domain;

import java.util.Set;

public class LottoChecker {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoChecker(Set<Integer> winningNums, int bonusNumber) {
        this.winningNumbers = new LottoTicket(winningNums);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoChecker(int bonusNumber, int... nums) {
        this.winningNumbers = new LottoTicket(nums);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank check(LottoTicket lottoTicket) {
        return Rank.matchRank(
            lottoTicket.calcMatchCount(winningNumbers),
            lottoTicket.isMatchBonusNum(bonusNumber)
        );
    }
}
