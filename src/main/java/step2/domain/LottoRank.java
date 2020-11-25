package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FOUR(3) {
        public Long findMoney() {
            return 5000L;
        }
    },
    THREE(4){
        public Long findMoney() {
            return 5000L;
        }
    },
    TWO(5){
        public Long findMoney() {
            return 5000L;
        }
    },
    ONE(6){
        public Long findMoney() {
            return 5000L;
        }
    };

    private final long number;

    LottoRank(long number) {
        this.number = number;
    }

    public static Optional<LottoRank> findRank(long winNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getNumber() == winNumberCount)
                .findAny();
    }

    public abstract Long findMoney();

    private long getNumber() {
        return this.number;
    }

}
