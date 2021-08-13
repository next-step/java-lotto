package lotto.domain;

public class WinnerNumbers {
    private final LottoTicket winnerNumbers;
    private final LottoBall bonusBall;

    private WinnerNumbers(LottoTicket winnerNumbers, LottoBall lottoBall) {
        this.winnerNumbers = winnerNumbers;
        this.bonusBall = lottoBall;
    }

    public static WinnerNumbers from(LottoTicket winnerNumbers, LottoBall lottoBall) {
        return new WinnerNumbers(winnerNumbers, lottoBall);
    }

    public Rank decideRank(LottoTicket lottoTicket) {
        return Rank.valueOf(lottoTicket.countMatchNumber(winnerNumbers), lottoTicket.contains(bonusBall.number()));
    }
}

