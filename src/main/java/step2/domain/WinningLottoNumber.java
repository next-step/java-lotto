package step2.domain;

import java.util.*;

public class WinningLottoNumber {
    private final List<Integer> winningNumbers = new ArrayList<>();

    public WinningLottoNumber(List<Integer> winNumberString) {
        this.winningNumbers.addAll(winNumberString);
        numberValid();
    }

    private void numberValid() {
        if (isEmpty()) {
            throw new IllegalArgumentException("잘못된 데이터를 입력했습니다.");
        }

        if (isNotMatchNumberCount()) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }

        Optional<Integer> isNotLottoNumber = this.winningNumbers.stream().filter(number -> isNotLottoNumber(number)).findAny();
        if (isNotLottoNumber.isPresent()) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력하였습니다.");
        }
    }

    private boolean isEmpty() {
        return Objects.isNull(this.winningNumbers) || this.winningNumbers.isEmpty();
    }

    private boolean isNotMatchNumberCount() {
        return this.winningNumbers.size() != LottoConstant.NEED_COUNT;
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
        return lotto.isContains(winNumber);
    }
}
