package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validationBlank(winningNumbers);
        this.winningNumbers = winningNumbersMake(winningNumbers);;
    }

    public List<Integer> winningNumbersMake(String winningNumbers){
        return Arrays.asList(winningNumbers.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void validationBlank(String winningNumbers){
        if(winningNumbers.isBlank()){
            throw new IllegalArgumentException("빈값이 들어왔습니다.");
        }
    }

    public void validationNumber(String winningNumbers){
        if(winningNumbers.isBlank()){
            throw new IllegalArgumentException("빈값이 들어왔습니다.");
        }
    }
}
