package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {
    UNRANKED(0, 0),
    COINCIDE_THREE(3, 5000),
    COINCIDE_FOUR(4, 50000),
    COINCIDE_FIVE(5, 1500000),
    COINCIDE_SIX(6, 2000000000);

    private final int number;
    private final int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public int getMoney() {
        return money;
    }

    public static Prize award(Lotto winLotto, Lotto lotto) {
        int count = (int) counting(winLotto.getLottoNumberList(), lotto.getLottoNumberList());
        return Arrays.stream(values())
                .filter(prize -> prize.number == count)
                .findFirst()
                .orElse(UNRANKED);
    }

    private static long counting(List<LottoNumber> winLottoNumberList, List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().filter(winLottoNumberList::contains).count();
    }

    public static Prize[] generateInRank() {
        return Arrays.stream(values()).skip(1L).toArray(Prize[]::new);
    }
}
