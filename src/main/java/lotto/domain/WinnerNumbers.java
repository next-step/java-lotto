package lotto.domain;

public class WinnerNumbers {
    private static final String BONUSBALL_INCLUSION_EXCEPTION_STATEMENT = "보너스 번호가 6개의 숫자에 포함되어 있습니다";

    private final LottoTicket winnerNumbers;
    private final LottoBall bonusBall;

    private WinnerNumbers(LottoTicket winnerNumbers, LottoBall bonusBall) {
        validate(winnerNumbers, bonusBall);
        this.winnerNumbers = winnerNumbers;
        this.bonusBall = bonusBall;
    }

    private void validate(LottoTicket winnerNumbers, LottoBall bonusBall) {
        if (winnerNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(BONUSBALL_INCLUSION_EXCEPTION_STATEMENT);
        }
    }

    public static WinnerNumbers from(LottoTicket winnerNumbers, LottoBall lottoBall) {
        return new WinnerNumbers(winnerNumbers, lottoBall);
    }

    public Rank decideRank(LottoTicket lottoTicket) {
        return Rank.valueOf(lottoTicket.countMatchNumber(winnerNumbers), lottoTicket.contains(bonusBall));
    }
}

