package lotto.strategy;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualStrategy extends DrawingStrategy {
    private final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private final static String INVALID_NUMBERS_MESSAGE = "유효하지 않은 로또 번호입니다.";
    private Set<Integer> numbers;

    public ManualStrategy(Set<Integer> numbers){
        this.numbers = numbers;
    }

    public ManualStrategy(String stringNumbers){
        Matcher matcher = NUMBER_PATTERN.matcher(stringNumbers);
        Set<Integer> numbers = new HashSet<>();

        while (matcher.find()) {
            int winnerNumber = Integer.parseInt(matcher.group());
            numbers.add(winnerNumber);
        }

        this.numbers = numbers;
    }

    @Override
    public Set<Integer> drawNumbers() {
        if(isInvalid(numbers)){
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
        return numbers;
    }
}
