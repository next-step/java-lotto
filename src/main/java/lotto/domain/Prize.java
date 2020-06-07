package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {
    UNRANKED(0, false, "3개 이하 일치 ", 0L),
    FIFTH(3, false, "3개 일치 ", 5000L),
    FOURTH(4, false, "4개 일치 ", 50000L),
    THIRD(5, false, "5개 일치 ", 1500000L),
    SECOND(5, true, "5개 일치, 보너스 볼 일치", 30000000L),
    FIRST(6, false, "6개 일치 ", 2000000000L);

    private final int number;
    private final boolean bonusMatched;
    private final String comment;
    private final long money;

    Prize(int number, boolean bonusMatched, String comment, long money) {
        this.number = number;
        this.bonusMatched = bonusMatched;
        this.comment = comment;
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public String getComment() {
        return comment;
    }

    public long getMoney() {
        return money;
    }

    public static Prize award(Lotto winLotto, boolean bonusMatched, Lotto lotto) {
        int count = (int) counting(winLotto.getLottoNumberList(), lotto.getLottoNumberList());
        return Arrays.stream(values())
                .filter(prize -> prize.number == count && prize.isBonusMatched() == bonusMatched)
                .findFirst()
                .orElse(UNRANKED);
    }

    private static long counting(List<Integer> winLottoNumberList, List<Integer> lottoNumberList) {
        return lottoNumberList.stream().filter(winLottoNumberList::contains).count();
    }

    public static Prize[] generateInRank() {
        return Arrays.stream(values()).skip(1L).toArray(Prize[]::new);
    }
}
