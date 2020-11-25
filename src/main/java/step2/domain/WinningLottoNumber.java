package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningLottoNumber {
    private List<Integer> winningNumbers;

    public WinningLottoNumber(String winNumberString) {
        stringFormatValid(winNumberString);
        stringToInt(split(winNumberString));
        numberValid();
    }

    private void stringFormatValid(String winNumberString) {
        if (isBlank(winNumberString)) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력했습니다.");
        }

        if (isNotMatchNumberCount(winNumberString)) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
    }

    private boolean isBlank(String winNumberString) {
        return Objects.isNull(winNumberString) || winNumberString.trim().isEmpty();
    }

    private boolean isNotMatchNumberCount(String winNumberString) {
        String[] split = winNumberString.split(",");
        return split.length != LottoConstant.NEED_COUNT;
    }

    private String[] split(String winNumberString) {
        return winNumberString.split(",");
    }

    private void stringToInt(String[] split) {
        this.winningNumbers =  Arrays.stream(split).map(m -> parseInt(m))
                .collect(Collectors.toList());
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new RuntimeException("숫자가 입력되지 않았습니다.");
        }
    }

    private void numberValid() {
        Optional<Integer> isNotLottoNumber = this.winningNumbers.stream().filter(number -> isNotLottoNumber(number)).findAny();
        if (isNotLottoNumber.isPresent()) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력하였습니다.");
        }
    }

    private boolean isNotLottoNumber(int number) {
        return number < LottoConstant.START_NO || number > LottoConstant.END_NO;
    }

    public List<Integer> getNumbers() {
        return this.winningNumbers;
    }

    public long findIsMatchNumberCount(Lotto lotto) {
        return this.winningNumbers.stream()
                .filter(winNumber -> isContains(winNumber, lotto))
                .count();
    }

    private boolean isContains(Integer winNumber, Lotto lotto) {
        return lotto.getNumbers().contains(winNumber);
    }
}
