package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int WINNING_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(int bonusNumber, int... winningNumbers) {
        this(Arrays.stream(winningNumbers).mapToObj(LottoNumber::of).collect(Collectors.toList()),
                LottoNumber.of(bonusNumber));
    }

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        HashSet<LottoNumber> uniqNumbers = new HashSet<>(winningNumbers);
        if (uniqNumbers.size() != WINNING_LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException("겹치지 않는 당첨 번호가 총 6개여야 합니다.");
        }
        if (uniqNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 겹치면 안됩니다.");
        }

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult match(LottoTicket ticket) {
        return LottoResult.of(getMatchCount(ticket), hasBonusNumber(ticket));
    }

    private boolean hasBonusNumber(LottoTicket ticket) {
        return ticket.hasNumber(bonusNumber);
    }

    private int getMatchCount(LottoTicket ticket) {
        return (int) winningNumbers.stream()
                .filter(ticket::hasNumber)
                .count();
    }
}
