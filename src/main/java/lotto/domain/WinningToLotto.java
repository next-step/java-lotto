package lotto.domain;

import calculator.Operator;

import java.util.Arrays;
import java.util.List;

public enum WinningToLotto {

    THREE(3){
        public int price() {
            return 5000;
        }
    },
    FOUR(4){
        public int price() {
            return 50000;
        }
    },
    FIVE(5){
        public int price() {
            return 1500000;
        }
    },
    SIX(6){
        public int price() {
            return 2000000000;
        }
    };

    private final int rank;

    WinningToLotto(int rank) {
        this.rank = rank;
    }

    public abstract int price();

    public static WinningToLotto valueOfLabel(int label) {
        return Arrays.stream(WinningToLotto.values())
                .filter(win -> win.rank == label)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int getWinningAmount(int rank){
        return WinningToLotto.valueOfLabel(rank).price();
    }

}
