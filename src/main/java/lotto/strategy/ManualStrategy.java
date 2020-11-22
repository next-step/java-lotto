package lotto.strategy;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualStrategy extends DrawingStrategy {
    private final static Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private final static String INVALID_NUMBERS_MESSAGE = "유효하지 않은 로또 번호입니다.";
    private SortedSet<Integer> numbers;

    public ManualStrategy(SortedSet<Integer> numbers){
        this.numbers = numbers;
    }

    public ManualStrategy(String stringNumbers){
        Matcher matcher = NUMBER_PATTERN.matcher(stringNumbers);
        SortedSet<Integer> numbers = new TreeSet<>();

        while (matcher.find()) {
            int winnerNumber = Integer.parseInt(matcher.group());
            numbers.add(winnerNumber);
        }

        this.numbers = numbers;
    }

    @Override
    public SortedSet<Integer> drawNumbers() {
        if(isInvalid(numbers)){
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
        return numbers;
    }
}
