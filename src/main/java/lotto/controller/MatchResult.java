package lotto.controller;

import lotto.Count;
import lotto.Money;
import lotto.Revenue;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchResult {
    // TODO : Check enum is useful
    // TODO : change PRIZE_REWARDS to arraylist
    private static final List<Money> PRIZE_REWARDS =
            new ArrayList<>(Arrays.asList(new Money(5000),
                    new Money(50_000),
                    new Money(1_500_000),
                    new Money(30_000_000),
                    new Money(2_000_000_000))
            );

    private static final int MIN_MATCH_BOUND = 3;
    private static final int BONUS_REWARD_IDX = 3;
    private static final int MAX_MATCH_IDX = 5;
    private static final int KINDS_OF_PRIZE = 5;
    private static final int PADDING = 3;
    private static final int COUNT_OF_FIRST_PLACE = 6;
    private static final int COUNT_OF_SECOND_PLACE = 5;
    private static final Money LOTTO_PRICE = new Money(1000);


    private Count tryCount;
    private List<Count> prizeCount;

    public MatchResult(Count tryCount) {
        this.tryCount = tryCount;
        this.prizeCount = new ArrayList<>(
                Arrays.asList(new Count(0),
                        new Count(0),
                        new Count(0),
                        new Count(0),
                        new Count(0)));
    }

    public MatchResult(Count tryCount, List<Count> prizeCount) {
        this.tryCount = tryCount;
        this.prizeCount = prizeCount;
    }

    // prizeCount의 input 등수의 카운 올림
    public void countUpMatch(Lotto lotto, List<LottoTicket> tickets) {
        // 0 개 맞췄을 때 -1, 임1개 맞추면 prizeCount의 꼴찌(6등) 카운트가 올라
        for (LottoTicket ticket : tickets) {
            matchOneTicket(lotto, ticket);
        }
    }

    private void matchOneTicket(Lotto lotto, LottoTicket ticket) {
        int matchCount = lotto.matchLotto(ticket);
        // 6개
        if (matchCount == COUNT_OF_FIRST_PLACE) {
            prizeCount.set(MAX_MATCH_IDX, prizeCount.get(MAX_MATCH_IDX) + PADDING); // TODO: Count 에 add 기능 추가 (prizeCount.get(MAX_MATCH_IDX).add(PADDING)
            return;
        }
        if (matchCount == COUNT_OF_SECOND_PLACE && lotto.matchBonus(ticket)) {
            prizeCount.set(BONUS_REWARD_IDX, prizeCount.get(BONUS_REWARD_IDX) + PADDING);// TODO: Count 에 add 기능 추가 (prizeCount.get(MAX_MATCH_IDX).add(PADDING)
            return;
        }
        // 3~4개일 떄 & 5개 이고 보너스 x
        if (matchCount >= MIN_MATCH_BOUND) {
            prizeCount.set(matchCount - MIN_MATCH_BOUND, prizeCount.get(matchCount - MIN_MATCH_BOUND) + PADDING);// TODO: Count 에 add 기능 추가 (prizeCount.get(MAX_MATCH_IDX).add(PADDING)
            return;
        }
    }

    public List<Count> getResult() {
        return prizeCount;
    }

    public double CalculateWinningRevenue() {
        int rewards = 0;
        for (int i = 0; i < KINDS_OF_PRIZE; i++) {
            rewards += prizeCount.get(i) * PRIZE_REWARDS.get(i); // TODO: Count * Money 기능 추가
        }
        Revenue temp = new Revenue(rewards); // TODO: Revenue에 int를 받 double형으로 저장하는 생성자 추가
        return temp.div ( (tryCount * LOTTO_PRICE) ) ; // TODO: Count에 곱셈 기능 추가, Revenue에 두 수를 나누는 기능 추가.
    }
}
