package lotto.strategy;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualStrategy implements DrawingStrategy {
    private final static Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private final static String LOTTO_SIZE_ERROR = "유효하지 않은 로또 입니다.";
    private LottoTicket numbers;

    public ManualStrategy(LottoTicket numbers){
        if(isNotValidCount(numbers)){
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }

        this.numbers = numbers;
    }

    public ManualStrategy(String stringNumbers){
        Matcher matcher = NUMBER_PATTERN.matcher(stringNumbers);
        LottoTicket numbers = new LottoTicket();

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(new LottoNumber(number));
        }

        if(isNotValidCount(numbers)){
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }

        this.numbers = numbers;
    }

    private boolean isNotValidCount(LottoTicket inputNumbers){
        return inputNumbers.size() < NUMBER_COUNT;
    }

    @Override
    public LottoTicket drawNumbers() {
        return numbers;
    }

}
