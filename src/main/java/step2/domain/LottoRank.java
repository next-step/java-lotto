package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FOUR(3) {
        public Long findMoney() {
            return LottoConstant.FOUR_MONEY;
        }
    },
    THREE(4){
        public Long findMoney() {
            return LottoConstant.THREE_MONEY;
        }
    },
    TWO(5){
        public Long findMoney() {
            return LottoConstant.TWO_MONEY;
        }
    },
    ONE(6){
        public Long findMoney() {
            return LottoConstant.ONE_MONEY;
        }
    };

    private final long number;

    LottoRank(long number) {
        this.number = number;
    }

    public static Optional<LottoRank> findRank(long winNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isSameNumber(lottoRank, winNumberCount))
                .findAny();
    }

    private static boolean isSameNumber(LottoRank lottoRank, long winNumberCount) {
        return lottoRank.number == winNumberCount;
    }

    public abstract Long findMoney();

}
