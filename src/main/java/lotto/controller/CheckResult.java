package lotto.controller;

import lotto.wrapper.Count;
import lotto.wrapper.Money;
import lotto.wrapper.Revenue;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchResult {
    private static final int MIN_MATCH_BOUND = 3;
    private static final int BONUS_REWARD_IDX = 3;
    private static final int MAX_MATCH_IDX = 4;
    private static final int KINDS_OF_PRIZE = 5;
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
            prizeCount.get(MAX_MATCH_IDX).countUp();
            return;
        }
        if (matchCount == COUNT_OF_SECOND_PLACE && lotto.matchBonus(ticket)) {
            prizeCount.get(BONUS_REWARD_IDX).countUp();
            return;
        }
        // 3~4개일 떄 & 5개 이고 보너스 x
        if (matchCount >= MIN_MATCH_BOUND) {
            prizeCount.get(matchCount - MIN_MATCH_BOUND).countUp();
            return;
        }
    }

    public List<Count> getResult() {
        return prizeCount;
    }

    public double calculateWinningRevenue() {
        int rewards = 0;
        for (int i = 0; i < KINDS_OF_PRIZE; i++) {
            rewards += calculateWinningRevenueOnce(i);
        }
        Revenue revenue = new Revenue(rewards);
        return revenue.divide((tryCount.getCount() * LOTTO_PRICE.getMoney()));
    }

    private int calculateWinningRevenueOnce(int i) {
        if (i == 3) {
            return prizeCount.get(i).getCount() * Prize.match(MatchLookUpTable
                    .lookUpTable.get(i), true).getPrize().getMoney();
        }
        return prizeCount.get(i).getCount() * Prize.match(MatchLookUpTable
                .lookUpTable.get(i), false).getPrize().getMoney();

    }
}
