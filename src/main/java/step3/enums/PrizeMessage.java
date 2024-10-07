package step3.enums;

import java.util.Arrays;

public enum PrizeMessage {

    RESULT_THREE_CORRECT(LottoPrize.THREE_MATCH, "3개 일치 (5000원)- {count}개"),
    RESULT_FOUR_CORRECT(LottoPrize.FOUR_MATCH, "4개 일치 (50000원)- {count}개"),
    RESULT_FIVE_CORRECT(LottoPrize.FIVE_MATCH, "5개 일치 (1500000원)- {count}개"),
    RESULT_FIVE_BONUS_CORRECT(LottoPrize.FIVE_BONUS_MATCH, "5개 일치, 보너스 볼 일치(30000000원) - {count}개"),
    RESULT_SIX_CORRECT(LottoPrize.SIX_MATCH, "6개 일치 (2000000000원)- {count}개");

    PrizeMessage(LottoPrize lottoPrize, String message) {
        this.lottoPrize = lottoPrize;
        this.message = message;
    }

    private final static String NOT_MATCH_COUNT = "일치하는 당첨개수가 없습니다.";
    private final static String LOTTO_COUNT = "{count}";
    private final LottoPrize lottoPrize;
    private final String message;

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    public String getMessage() {
        return message;
    }

    //로또 숫자 일치 카운트와, 로또의 개수를 입력받으면 출력할 메시지를 내려준다.
    public static String matchCountMessage(LottoPrize lottoPrize, int count) {
        return Arrays.stream(PrizeMessage.values())
                .filter(prize -> prize.getLottoPrize() == lottoPrize)
                .map(prize -> prize.message.replace(LOTTO_COUNT, String.valueOf(count)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COUNT));
    }
}
