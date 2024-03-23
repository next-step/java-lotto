package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Integer> calculateMatchCounts() {
        List<Integer> matchCounts = Arrays.asList(0, 0, 0, 0, 0);
        for (Prize prize : prizes) { // prizes는 LottoTicket의 개수만큼 생성된 Prize 객체들을 가지고 있음
            if (prize == Prize.FIRST_PRIZE) {
                matchCounts.set(4, matchCounts.get(4) + 1);
            } else if (prize == Prize.SECOND_PRIZE) {
                matchCounts.set(3, matchCounts.get(3) + 1);
            } else if (prize == Prize.THIRD_PRIZE) {
                matchCounts.set(2, matchCounts.get(2) + 1);
            } else if (prize == Prize.FOURTH_PRIZE) {
                matchCounts.set(1, matchCounts.get(1) + 1);
            } else if (prize == Prize.FIFTH_PRIZE) {
                matchCounts.set(0, matchCounts.get(0) + 1);
            }
        }
        return matchCounts;
    }

}
