package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final LottoTicket ballNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusBall) {
        this(new LottoTicket(
                winningNumbers.stream().map(LottoNumber::from).collect(Collectors.toList())),
            new LottoNumber(bonusBall));
    }

    public WinningNumbers(final LottoTicket winningNumbers, final LottoNumber bonusBall) {
        this.ballNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public LottoRank getRankForLottoTicket(LottoTicket lottoTicket) {
        int count = lottoTicket.getMatchCount(this.ballNumbers);
        boolean hasBonus = lottoTicket.contains(bonusBall);
        return LottoRank.valueOf(count, hasBonus);
    }
}
