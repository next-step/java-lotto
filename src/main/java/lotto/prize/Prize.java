package lotto.prize;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000, "로또 번호 6개를 다 맞은 경우"),
    SECOND(5, 1500000, "로또 번호 5개를 맞은 경우"),
    THIRD(4, 50000, "로또 번호 4개를 맞은 경우"),
    FOURTH(3, 5000, "로또 번호 3개를 맞은 경우");

    private final int matchedLottoNumbers;
    private final int prizeAmount;
    private final String description;

    Prize(int matchedLottoNumbers, int prize, String description) {
        this.matchedLottoNumbers = matchedLottoNumbers;
        this.prizeAmount = prize;
        this.description = description;
    }

    public static int getPrizeAmount(int matchedLottoNumbers) {
        return Arrays.stream(Prize.values())
                .filter(p -> p.matchedLottoNumbers == matchedLottoNumbers)
                .findFirst()
                .map(Prize::getPrizeAmount)
                .orElse(0);
    }

    public int getMatchedLottoNumbers() {
        return matchedLottoNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}