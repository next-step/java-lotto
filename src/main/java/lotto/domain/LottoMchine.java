package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.utils.LottoHelper;

public class LottoMchine {
    private final int LOTTO_NUMERS = 6;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> numbers = null;

    public LottoMchine() {
        numbers = makeBalls();
    }

    public LottoTicket createTicket() {
        return new LottoTicket(selectBalls());
    }

    private List<Integer> selectBalls() {
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_NUMERS);
    }

    public LottoResult check(String winningNumber, List<LottoTicket> tikets) {
        List<Integer> numbers = LottoHelper.convertToList(winningNumber);
       
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket ticket : tikets) {
            int matchCount = ticket.howManyMatch(numbers);
            lottoResult.addResult(matchCount);
        }
        
        return lottoResult;
    }

    private List<Integer> makeBalls() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
    }

    public static int getPrize(int matchCount) {
        return LottoPrize.findPrize(matchCount);
    }

    enum LottoPrize {
        MATCH3(3, 5000),
        MATCH4(4, 50000),
        MATCH5(5, 1500000),
        MATCH6(6, 2000000000);

        private int matchCount;
        private int prize;

        LottoPrize(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public static int findPrize(int matchCount) {
            for (LottoPrize prize:LottoPrize.values()) {
                if (prize.isMatchedCount(matchCount)) {
                    return prize.prize;
                }
            }
            return 0;
        }

        private boolean isMatchedCount(int matchCount) {
            return this.matchCount == matchCount;
        }
    }
}
