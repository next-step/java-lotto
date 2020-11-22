package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.HashMap;
import java.util.Map;

public enum LottoStatusEnum {

    PRICE_4ST(4, 5000, "3개 일치", 0),

    PRICE_3ST(3, 50000, "4개 일치", 0),

    PRICE_2ST(2, 1500000, "5개 일치", 0),

    PRICE_1ST(1, 2000000000, "6개 일치", 0);

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
    static{
        for(LottoStatusEnum prize : LottoStatusEnum.values()){
            matchByCountMap.put(prize.getLottoRank(), prize);
        }
    }

    public void addWinningCount(){
        this.winningCount++;
    }

    public static LottoStatusEnum findByPrice(int winningCount){
        if(!matchByCountMap.containsKey(winningCount)){
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2RankException());
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
