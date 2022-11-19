package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SEPARATOR = ",";
    private static final String NULL_EXCEPTION_MESSGAE = "빈값이 들어왔습니다.";
    private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "당첨 번호는 6개만 입력해주세요.";

    List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validationBlank(winningNumbers);
        this.winningNumbers = winningNumbersMake(winningNumbers);
    }

    public List<Integer> winningNumbersMake(String winningNumbers){
        List<Integer> numbers = Arrays.asList(winningNumbers.split(SEPARATOR)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validationNumbersSizeCheck(numbers);
        return numbers;
    }

    public void validationBlank(String winningNumbers){
        if(winningNumbers.isBlank()){
            throw new NullPointerException(NULL_EXCEPTION_MESSGAE);
        }
    }

    public void validationNumbersSizeCheck(List<Integer> winningNumbers){
        if(winningNumbers.size() > 6){
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
