package lotto.domain;


import java.util.Arrays;
import java.util.function.Consumer;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000, LottoScore::addFirst),
    SECOND_MATCH(5, 30_000_000, LottoScore::addSecond),
    THIRD_MATCH(5, 1_500_000, LottoScore::addThird),
    FOURTH_MATCH(4, 50_000, LottoScore::addFourth),
    FIFTH_MATCH(3, 5_000, LottoScore::addFifth) ,
    NONE_MATCH(0, 0, lottoScore -> {});

    private final int matchOfCount;
    private int price;
    private final Consumer<LottoScore> lottoScoreConsumer;

    LottoMatcher(int matchOfCount, int price, Consumer<LottoScore> lottoScoreConsumer) {
        this.matchOfCount = matchOfCount;
        this.price = price;
        this.lottoScoreConsumer = lottoScoreConsumer;
    }

    private boolean is(int matchOfCount) {
        return this.matchOfCount == matchOfCount;
    }

    public static LottoMatcher of(int matchOfCount, boolean matchBonus) {
        if(matchOfCount == 5) {
            return matchBonus ? LottoMatcher.SECOND_MATCH : LottoMatcher.THIRD_MATCH;
        }

        return Arrays.stream(LottoMatcher.values())
                .filter(lottoResult -> lottoResult.is(matchOfCount))
                .findAny()
                .orElse(LottoMatcher.NONE_MATCH);
    }

    public int price() {
        return price;
    }

    public void incrementScore(LottoScore lottoScore){
        lottoScoreConsumer.accept(lottoScore);
    }

    public int amount(int count) {
        return price * count;
    }
}
