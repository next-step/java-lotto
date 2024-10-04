package step2.enums;

import step2.enums.ExceptionMessage;

import java.util.Arrays;

public enum PrizeMessage {

    RESULT_THREE_CORRECT(3, "3개 일치 (5000원)- {count}개"),
    RESULT_FOUR_CORRECT(4, "4개 일치 (50000원)- {count}개"),
    RESULT_FIVE_CORRECT(5, "5개 일치 (1500000원)- {count}개"),
    RESULT_SIX_CORRECT(6, "6개 일치 (2000000000원)- {count}개");

    PrizeMessage(int matchCount, String message) {
        this.matchCount = matchCount;
        this.message = message;
    }

    private final static String LOTTO_COUNT = "{count}";
    private final int matchCount;
    private final String message;

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    //로또 숫자 일치 카운트와, 로또의 개수를 입력받으면 출력할 메시지를 내려준다.
    public static String matchCountMessage(int matchCount, int count) {
        return Arrays.stream(PrizeMessage.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .map(prize -> prize.message.replace(LOTTO_COUNT, String.valueOf(count)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_MATCH_COUNT.message()));
    }
}
