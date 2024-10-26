package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WinningLotto {

    private List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    public WinningLotto(String winningNumbers, int bonusNumber) {
        this.numbers = parseWinningNumbers(winningNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.numbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String winningNumber) {
        return stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int countMatchNumber(List<LottoNumber> boughtLottoNumbers) {
        return (int) boughtLottoNumbers.stream()
                .filter(number -> !number.equals(bonusNumber))
                .filter(numbers::contains)
                .count();
    }

    public boolean checkContainsBonusNumber(List<LottoNumber> boughtLottoNumbers) {
        return boughtLottoNumbers.contains(bonusNumber);
    }

    public static void isValidBonusNumber(String lastWeekWinningNumbers, int bonusNumber) {
        List<Integer> winningNumbers = stream(lastWeekWinningNumbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("지난 주 당첨 번호와 보너스 볼이 중복되었습니다.");
        }
    }

}
