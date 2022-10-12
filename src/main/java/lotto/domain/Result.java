package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Result implements Iterable<Winning> {
    private final List<Winning> winning;

    public Result(List<Winning> winning) {
        this.winning = winning;
    }
    
    public static Result of(LottoNumbers numbers, LottoNumber luckyLottoNumber) {
        return new Result(winnings(numbers, luckyLottoNumber));
    }

    private static List<Winning> winnings(LottoNumbers numbers, LottoNumber luckyLottoNumber) {
        return Prize.getAll()
                    .stream()
                    .map(prize -> winning(prize, numbers.match(luckyLottoNumber, prize.getMatchCount())))
                    .filter(winning -> winning.numberCount() > 0).collect(Collectors.toList());
    }

    private static Winning winning(Prize prize, LottoNumbers lottoNumbers) {
        return new Winning(prize, lottoNumbers);
    }

    @Override
    public Iterator<Winning> iterator() {
        return winning.iterator();
    }
}
