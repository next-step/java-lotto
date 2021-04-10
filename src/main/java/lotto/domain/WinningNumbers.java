package lotto.domain;

import lotto.enums.WinningRank;

import java.util.Objects;

public class WinningNumbers {
    private static final String CHECK_DUPLICATION = "보너스 번호가 당첨 번호에 포함되어 있는지 확인해주세요.";
    private final LottoNumbers winningNumbers;
    private final BonusBall bonusBall;

    public WinningNumbers(int bonusBall, int... winningNumbers) {
        this(new BonusBall(bonusBall), LottoNumbers.from(winningNumbers));
    }

    public WinningNumbers(BonusBall bonusBall, LottoNumbers winningNumbers) {
        checkDuplication(winningNumbers, bonusBall);
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public WinningRank matchWith(LottoTicket lottoTicket) {
        MatchedCount matchedCount = new MatchedCount(winningNumbers, lottoTicket);
        boolean matchBonus = lottoTicket.hasBonusNumber(bonusBall);

        return WinningRank.findByMacthedCount(matchedCount, matchBonus);
    }

    private void checkDuplication(LottoNumbers lottoNumbers, BonusBall bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CHECK_DUPLICATION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusBall);
    }
}
