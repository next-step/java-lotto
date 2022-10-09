package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Result implements Iterable<Winning> {
    private static final int MIN_MATCH_COUNT = 3;
    
    private final List<Winning> winning;

    public Result(List<Winning> winning) {
        this.winning = winning;
    }
    
    public static Result of(LottoNumbers numbers, LottoNumber luckyLottoNumber) {
        return new Result(winnings(numbers, luckyLottoNumber));
    }

    private static List<Winning> winnings(LottoNumbers numbers, LottoNumber luckyLottoNumber) {
        List<Winning> winnings = new ArrayList<>();
        for (int matchCount = MIN_MATCH_COUNT; matchCount <= luckyLottoNumber.count(); matchCount++) {
            winnings.add(winning(matchCount, numbers.match(luckyLottoNumber, matchCount)));
        }
        return winnings;
    }

    private static Winning winning(int matchCount, LottoNumbers numberCount) {
        return new Winning(matchCount, Prize.get(matchCount), numberCount);
    }

    @Override
    public Iterator<Winning> iterator() {
        return winning.iterator();
    }
}
