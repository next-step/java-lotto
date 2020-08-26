package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> winningNumbers;

    public WinningLottoNumbers(String inputWinningNumber) {
        validation(inputWinningNumber);
        this.winningNumbers = changeToList(inputWinningNumber);
    }

    private void validation(String inputWinningNumber) {
        if (inputWinningNumber == null || inputWinningNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력하신 당첨번호가 올바르지 않습니다.");
        }
    }

    private List<LottoNumber> changeToList(String inputWinningNumber) {
        List<LottoNumber> lottoNumbers =
                Arrays.stream(inputWinningNumber.split(LOTTO_NUMBER_DELIMITER))
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호 갯수를 확인해주세요.");
        }
        return lottoNumbers;
    }

    protected int getMatchingCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers
                .stream()
                .filter(getWinningNumbers()::contains)
                .count();

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }
}
