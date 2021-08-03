package lotto;

import lotto.exception.InvalidLottoRankException;

import java.util.Arrays;
import java.util.Objects;

public enum LottoRankEnum {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    ALL_MATCH(6, 2000000000);

    private int countOfMatch;
    private int price;

    private LottoRankEnum(int countOfMatch, int price) {
        this.countOfMatch = countOfMatch;
        this.price = price;

    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRankEnum valueOf(int countOfMatch) {
        return Arrays.stream(LottoRankEnum.values())
                .filter(lottoRankEnum -> lottoRankEnum.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElseThrow(InvalidLottoRankException::new);
    }
}
