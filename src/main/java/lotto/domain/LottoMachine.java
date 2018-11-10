package lotto.domain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_NUMERS = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private List<LottoBall> balls = null;

    public LottoMachine() {
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
            lottoResult.addResult(LottoPrize.findPrize(matchCount));
        }
        
        return lottoResult;
    }

    private List<LottoBall> makeBalls() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).mapToObj(number -> new LottoBall(number)).collect(Collectors.toList());
    }
}
