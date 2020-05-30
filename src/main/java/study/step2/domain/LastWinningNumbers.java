package study.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LastWinningNumbers {
    private final static String DELIMITER = ",";
    private final static String WINNING_NUMBERS_MIN_EXCPETION = "당첨번호는 6개보다 작게 입력할 수 없습니다.";
    private final static String WINNING_NUMBERS_ONLY_NUMBER_EXCPETION = "당첨 번호는 숫자만 입력할 수 있습니다.";
    private final static Pattern PATTERN = Pattern.compile("^[0-9]+$");

    private final List<Integer> winningNumbers;

    public LastWinningNumbers(String winningNumbers) {
        this(convertToList(winningNumbers));
    }

    private LastWinningNumbers(List<Integer> winningNumbers){
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() < 6){
            throw new IllegalArgumentException(WINNING_NUMBERS_MIN_EXCPETION);
        }
    }

    private static List<Integer> convertToList(String winningNumbers) {
        return convertToIntegerList(splitNumbers(winningNumbers));
    }

    private static List<Integer> convertToIntegerList(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                     .map(value -> new Integer(validateNumber(value)))
                     .collect(Collectors.toList());
    }

    private static String[] splitNumbers(String winningNumbers) {
        return winningNumbers.split(DELIMITER);
    }

    private static String validateNumber(String winningNumber) {
        Matcher matcher = PATTERN.matcher(winningNumber);
        if(!matcher.find()){
            throw new IllegalArgumentException(WINNING_NUMBERS_ONLY_NUMBER_EXCPETION);
        }
        return winningNumber;
    }

    public List<Integer> getWinningNumbers(){
        return this.winningNumbers;
    }
}
