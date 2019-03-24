package lotto.domain;

import java.util.List;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;
    public static final int EMPTY = 0;

    protected final List<LottoBall> lottoBalls;
    private boolean bonusMatch;

    public LottoTicket(List<LottoBall> lottoBalls) {
        validateLottoBalls(lottoBalls);
        this.lottoBalls = lottoBalls;
    }

    private void validateLottoBalls(List<LottoBall> lottoBalls) {
        checkNullOrEmpty(lottoBalls);
        checkSize(lottoBalls);
        checkDuplication(lottoBalls);
    }

    private boolean checkNullOrEmpty(List<LottoBall> lottoBalls) {
        if (lottoBalls == null || lottoBalls.size() == EMPTY) {
            error();
        }
        return true;
    }

    private boolean checkSize(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LOTTO_SIZE) {
            error();
        }
        return true;
    }

    private boolean checkDuplication(List<LottoBall> lottoBalls) {
        for (int i = 1; i < lottoBalls.size(); i++) {
            isDuplicated(lottoBalls.get(i-1), lottoBalls.get(i));
        }
        return false;
    }

    protected void isDuplicated(LottoBall lottoBall, LottoBall lottoBall1) {
        if (lottoBall.compareTo(lottoBall1) == LottoBall.DUPLICATED) {
            error();
        }
    }

    private void error() {
        throw new IllegalArgumentException();
    }

    public int matchCount(WinningLotto winningLotto) {
        int count = 0;
        for (LottoBall lottoBall : lottoBalls) {
            count = contains(count, winningLotto, lottoBall);
        }

        if (count == LottoRank.MATCH_COUNT_FIVE) {
            bonusMatch = matchBonusNumber(winningLotto);
        }

        return count;
    }

    private int contains(int count, WinningLotto winningLotto, LottoBall lottoBall) {
        for (LottoBall winningBall : winningLotto.lottoBalls) {
            count = equals(count, winningBall, lottoBall);
        }
        return count;
    }

    private int equals(int count, LottoBall winningBall, LottoBall lottoBall) {
        if (lottoBall.equals(winningBall)) {
            count++;
        }
        return count;
    }

    public boolean matchBonusNumber(WinningLotto winningLotto) {
        boolean matchNumber = false;
        for (LottoBall lottoBall : lottoBalls) {
            matchNumber = isMatch(matchNumber, winningLotto, lottoBall);
        }
        return matchNumber;
    }

    private boolean isMatch(boolean matchNumber, WinningLotto winningLotto, LottoBall lottoBall) {
        if (winningLotto.matchBonusNumber(lottoBall)) {
            matchNumber = true;
        }
        return matchNumber;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    @Override
    public String toString() {
        return lottoBalls.toString();
    }
}
