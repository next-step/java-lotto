package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static  final String LOTTO_NUMBER_DELIMITER = ",";
    private List<Integer> winningNumbers; // 지난주 당첨 번호

    public WinningLotto(String inputWinningNumber) {
        this.winningNumbers = invalidAndToArray(inputWinningNumber);
    }

    private List<Integer> invalidAndToArray(String inputWinningNumber) {
        if(inputWinningNumber.trim().isEmpty() || inputWinningNumber == null){
            throw new IllegalArgumentException("당첨 번호를 정확하게 입력해주세요");
        }
        List<Integer> list =
                Arrays.stream(inputWinningNumber.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //TODO : list 에 대한 validation ( 6개인지)
        return list;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
