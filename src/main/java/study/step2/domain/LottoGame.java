package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoGame {
    private final static String MIN_PRICE_EXCEPTION = "그 돈으론 로또를 1장도 살 수 없습니다.";
    private final static String NULL_PRICE_EXCEPTION = "금액은 빈 값을 입력할 수 없습니다.";
    private final static String NOT_NUMBER_EXCEPTION = "금액은 숫자가 아닌 값을 입력할 수 없습니다.";
    private final int LOTTO_PRICE_PER_PIECE = 1000;
    private final static Pattern PATTERN = Pattern.compile("^[0-9]+$");

    private final long price;

    public LottoGame(String price){
        this(convertToLongType(price));
    }

    private LottoGame(long price) {
        validateMinPrice(price);
        this.price = price;
    }

    private void validateMinPrice(long price) {
        if (price < 1000){
            throw new IllegalArgumentException(MIN_PRICE_EXCEPTION);
        }
    }

    private static void validatePrice(String price) {
        if (Objects.isNull(price) || price.trim().isEmpty()){
            throw new IllegalArgumentException(NULL_PRICE_EXCEPTION);
        }
    }

    private static long convertToLongType(String price) {
        validatePrice(price);
        parsingExceptionCheck(price);
        return Long.parseLong(price);
    }

    private static void parsingExceptionCheck(String price) {
        Matcher matcher = PATTERN.matcher(price);
        if (!matcher.find()){
            throw new NumberFormatException(NOT_NUMBER_EXCEPTION);
        }
    }

    public List<LottoTicket> buyLotto(LottoNumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        long lottoCount = convertMoneyToLottoTickets();
        for (long i = 0; i < lottoCount; i++){
            lottoTickets.add(new LottoTicket(numberGenerator));
        }
        return lottoTickets;
    }

    public double getEarningsRate(long prizeMoney ){
        return (int)(prizeMoney / (double)price * 100) / 100.0;
    }

    private long convertMoneyToLottoTickets() {
        return price/LOTTO_PRICE_PER_PIECE;
    }
}
