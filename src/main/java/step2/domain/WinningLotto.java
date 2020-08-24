package step2.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private List<String> winningNumber; // 지난주 당첨 번호

    public WinningLotto(String inputWinningNumber) {
        this.winningNumber = invalidAndToArray(inputWinningNumber);
    }

    private List<String> invalidAndToArray(String inputWinningNumber) {
        if(inputWinningNumber.trim().isEmpty() || inputWinningNumber == null){
            throw new IllegalArgumentException("당첨 번호를 정확하게 입력해주세요");
        }
        List<String> list = Arrays.asList(inputWinningNumber.split(","));
        return list;
    }

    public void getResult(Lotto lotto) {
        winningNumber.contains(lotto);
    }
}
