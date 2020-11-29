package lotto.strategy;

import lotto.model.lotto.LottoNumber;


import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualStrategy implements DrawingStrategy {
    private final static Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private final static String LOTTO_SIZE_ERROR = "유효하지 않은 로또 입니다.";
    private SortedSet<LottoNumber> numbers;

    public ManualStrategy(SortedSet<LottoNumber> numbers){
        if(isNotValidCount(numbers)){
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }

        this.numbers = numbers;
    }

    public ManualStrategy(String stringNumbers){
        Matcher matcher = NUMBER_PATTERN.matcher(stringNumbers);
        SortedSet<LottoNumber> numbers = new TreeSet<>();

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(LottoNumber.of(number));
        }

        if(isNotValidCount(numbers)){
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }

        this.numbers = numbers;
    }

    private boolean isNotValidCount(SortedSet<LottoNumber> inputNumbers){
        return inputNumbers.size() < NUMBER_COUNT;
    }

    @Override
    public SortedSet<LottoNumber> drawNumbers() {
        return numbers;
    }

}
