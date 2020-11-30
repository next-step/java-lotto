package step4.lotto.domain;

import step4.lotto.util.LottoErrorMessage;

import java.util.HashMap;
import java.util.Map;

public enum LottoStatusEnum {
    PRICE_1ST(1, 2_000_000_000, "6개 일치", 0),
    PRICE_2ST(2, 30_000_000, "5개 일치, 보너스 볼 일치", 0),
    PRICE_3ST(3, 1_500_000, "5개 일치", 0),
    PRICE_4ST(4, 50_000, "4개 일치", 0),
    PRICE_5ST(5, 5_000, "3개 일치", 0);

    private int lottoRank = 0;
    private int winningCount = 0;
    private int price = 0;
    private String message = "";

    LottoStatusEnum(int lottoRank, int price, String message, int winningCount) {
        this.lottoRank = lottoRank;
        this.price = price;
        this.message = message;
        this.winningCount = 0;
    }

    private static final Map<Integer, LottoStatusEnum> matchByCountMap = new HashMap<>();

    static {
        for (LottoStatusEnum prize : LottoStatusEnum.values()) {
            matchByCountMap.put(prize.getLottoRank(), prize);
        }
    }

    public void addWinningCount() {
        this.winningCount++;
    }

    public static LottoStatusEnum findByCount(int winningCount) {
        if (!matchByCountMap.containsKey(winningCount)) {
            throw new RuntimeException(LottoErrorMessage.getLottoRankException());
        }

        return matchByCountMap.get(winningCount);
    }

    public int getLottoRank() {
        return lottoRank;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public int getWinningCount() {
        return winningCount;
    }


}
