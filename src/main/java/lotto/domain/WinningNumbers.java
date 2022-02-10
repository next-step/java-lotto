package lotto.domain;

import static lotto.util.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> ballNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusBall) {
        this(winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()),
            new LottoNumber(bonusBall));
    }

    public WinningNumbers(final List<LottoNumber> winningNumbers, final LottoNumber bonusBall) {
        validateDuplicate(winningNumbers);
        this.ballNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    private void validateDuplicate(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ELEMENT);
        }
    }

    public LottoRank getRankForLottoTicket(LottoTicket lottoTicket) {
        int count = lottoTicket.getMatchCount(this.ballNumbers);
        boolean hasBonus = lottoTicket.contains(bonusBall);
        return LottoRank.valueOf(count, hasBonus);
    }
}
