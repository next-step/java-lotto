package step2.domain;


import static step2.domain.LottoWinGenerator.PRIZE_MAP;

public class Prize {

    private static final int NO_PRIZE = 0;

    private final int value;

    private final int lottoWinNumbers;

    public int getValue() {
        return value;
    }


    public Prize(int value) {
        this.value = value;
        this.lottoWinNumbers = PRIZE_MAP.get(value);
    }


    public boolean isWin() {
        return lottoWinNumbers > NO_PRIZE;
    }

}
