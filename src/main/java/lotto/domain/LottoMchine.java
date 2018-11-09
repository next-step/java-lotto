package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.utils.LottoHelper;
import lotto.utils.RandomNumberGenerator;

public class LottoMchine {
    private final int LOTTO_NUMERS = 6;
    private final int LOTTO_MIX_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;

    public LottoMchine() {
    }

    public LottoTicket createTicket() {
        return new LottoTicket(RandomNumberGenerator.generate(LOTTO_MIX_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMERS));
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

    public static int getPrize(int matchCount) {
        return LottoPrize.findPize(matchCount);
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

        public static int findPize(int matchCount) {
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
