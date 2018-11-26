package lotto;

import java.util.stream.Stream;

public enum LottoType {
    THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 150_000), SIX(6, 200_000_000);

    private int winningNumber;
    private int reword;

    LottoType(int winningNumber, int reword) {
        this.winningNumber = winningNumber;
        this.reword = reword;
    }

    public static LottoType findLottoType(int winningNumber) {
        return Stream.of(values())
                .filter(value -> value.isSameWinningNumber(winningNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("타입정보를 찾을 수 없습니다" + winningNumber));

    }

    private boolean isSameWinningNumber(int winningNumber) {
        return this.winningNumber == winningNumber;
    }

    public int computeEarning(int winningCount) {
        return this.reword * winningCount;
    }

    @Override
    public String toString() {
        return winningNumber + "개 일치 (" + reword + "원)";
    }
}
