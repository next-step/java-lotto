package step2.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    _3_RANK(3, 5000),
    _4_RANK(4, 50000),
    _5_RANK(5, 1500000),
    _6_RANK(6, 2000000000);

    private final Integer rank;
    private final Integer money;

    LottoRank(int rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public static LottoRank find(Integer rank) {
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.rank.equals(rank))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("랭크를 찾을 수 없습니다."));
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getRank() {
        return rank;
    }

}
