package lotto.domain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMchine {
    public static final int LOTTO_NUMERS = 6;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;

    private List<LottoBall> balls = null;

    public LottoMchine() {
        this.balls = makeBalls();
    }

    public LottoTicket createTicket() {
        return createTicket(selectBalls());
    }

    public LottoTicket createTicket(List<LottoBall> balls) {
        return new LottoTicket(balls);
    }

    private List<LottoBall> selectBalls() {
        Collections.shuffle(this.balls);
        return this.balls.subList(0, LOTTO_NUMERS);
    }

    public LottoResult check(LottoTicket winningTicket, List<LottoTicket> tickets) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.howManyMatch(winningTicket);
            lottoResult.addResult(matchCount);
        }
        
        return lottoResult;
    }

    private List<LottoBall> makeBalls() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).mapToObj(number -> new LottoBall(number)).collect(Collectors.toList());
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
