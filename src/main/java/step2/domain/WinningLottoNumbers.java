package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> winningNumbers;

    public WinningLottoNumbers(String inputWinningNumber) {
        this.winningNumbers = invalidAndToArray(inputWinningNumber);
    }

    private List<Integer> invalidAndToArray(String inputWinningNumber) {
        if (inputWinningNumber == null || inputWinningNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 번호를 정확하게 입력해주세요");
        }
        List<Integer> list =
                Arrays.stream(inputWinningNumber.split(LOTTO_NUMBER_DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        if (list.size() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호를 정확하게 입력해주세요");
        }
        return list;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
