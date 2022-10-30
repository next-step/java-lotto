package lotto.domain;

import java.util.List;

public class Result {
    private final Winnings winnings;
    private final RateOfReturn rateOfReturn;

    public Result(final Winnings winnings, final Money investment) {
        this.winnings = winnings;
        this.rateOfReturn = new RateOfReturn(investment, winnings.income());
    }
    
    public static Result of(final LottoNumbers numbers, final LottoNumber luckyLottoNumber, final int bonusNumber, final Money investment) {
        return new Result(winnings(numbers, luckyLottoNumber, bonusNumber), investment);
    }
    
    public List<Winning> winnings() {
        return winnings.getWinnings();
    }

    public double rateOfReturn() {
        return rateOfReturn.value();
    }
    
    private static Winnings winnings(LottoNumbers numbers, LottoNumber luckyLottoNumber, int bonusNumber) {
        Winnings winnings = new Winnings();
        for (LottoNumber number : numbers) {
            MatchingCount count = number.matchCount(luckyLottoNumber, bonusNumber);
            winnings.add(new Winning(Prize.valueOf(count), new LottoNumbers(List.of(number))));
        }

        return winnings;
    }
}
