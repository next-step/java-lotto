package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SEPARATOR = ",";
    private static final String NULL_EXCEPTION_MESSGAE = "빈값이 들어왔습니다.";
    private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "당첨 번호는 6개만 입력해주세요.";
    private static final String BONUSNUMBER_EXCEPTION = "이미 당첨번호에 포함 되어 있습니다.";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers) {
        validationBlank(winningNumbers);
        validationNumbersSizeCheck(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = 0;
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validationBlank(winningNumbers);
        validationNumbersSizeCheck(winningNumbers);
        validationBonusNumberCheck(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers winningNumbersMake(String winningNumbers, int bonusNumber){
        return new WinningNumbers(Arrays.asList(winningNumbers.split(SEPARATOR)).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()), bonusNumber);
    }


    public void validationBlank(List<Integer> winningNumbers){
        if(winningNumbers.isEmpty()){
            throw new NullPointerException(NULL_EXCEPTION_MESSGAE);
        }
    }

    public void validationNumbersSizeCheck(List<Integer> winningNumbers){
        if(winningNumbers.size() > 6){
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validationBonusNumberCheck(int bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(BONUSNUMBER_EXCEPTION);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
