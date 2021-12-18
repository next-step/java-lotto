package lottery.domain;

import java.util.Objects;

public class WinningLotteryNumbers {

    private static final String EXCEPTION_MESSAGE_DUPLICATED_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final LotteryTicket winningLotteryTicket;
    private final LotteryNumber bonusNumber;

    private WinningLotteryNumbers(final LotteryTicket winningLotteryTicket, final LotteryNumber bonusNumber) {
        this.winningLotteryTicket = winningLotteryTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotteryNumbers of(final LotteryTicket winningLotteryTicket, final LotteryNumber bonusNumber) {
        if (winningLotteryTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATED_NUMBER);
        }

        return new WinningLotteryNumbers(winningLotteryTicket, bonusNumber);
    }

    public Rank matchedRank(final LotteryTicket lotteryTicket) {
        final int countOfMatch = winningLotteryTicket.matchedCount(lotteryTicket);
        final boolean matchBonus = lotteryTicket.contains(bonusNumber);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotteryNumbers that = (WinningLotteryNumbers) o;
        return Objects.equals(winningLotteryTicket, that.winningLotteryTicket) && Objects.equals(bonusNumber,
            that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotteryTicket, bonusNumber);
    }
}
