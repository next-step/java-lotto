package lotto.prize;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2000000000, "로또 번호 6개를 다 맞은 경우"),
    SECOND(5, 1500000, "로또 번호 5개를 맞은 경우"),
    THIRD(4, 50000, "로또 번호 4개를 맞은 경우"),
    FOURTH(3, 5000, "로또 번호 3개를 맞은 경우");

    private final int matchedLottoNumbers;
    private final int prizeAmount;
    private final String description;

    LottoPrize(int matchedLottoNumbers, int prize, String description) {
        this.matchedLottoNumbers = matchedLottoNumbers;
        this.prizeAmount = prize;
        this.description = description;
    }

    public static int getPrizeAmount(int matchedLottoNumbers) {
        return Arrays.stream(LottoPrize.values())
                .filter(p -> p.matchedLottoNumbers == matchedLottoNumbers)
                .findFirst()
                .map(LottoPrize::getPrizeAmount)
                .orElse(0);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}