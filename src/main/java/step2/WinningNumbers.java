package step2;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumberList;

    public WinningNumbers() {
        this.winningNumberList = new ArrayList<>();
    }

    public void addNumber(int number) throws IllegalArgumentException {
        validation(number);
        winningNumberList.add(number);
    }

    public int countingWinningNumbers(List<Integer> lottoNumberList) {
        return (int) (lottoNumberList.stream().filter(number -> winningNumberList.contains(number)).count());
    }

    private void validation(int number) throws IllegalArgumentException {
        if (winningNumberList.size() > 6) {
            throw new IllegalArgumentException("당첨 번호는 6개입니다.");
        }

        if (winningNumberList.contains(number)) {
            throw new IllegalArgumentException("중복숫자를 제거해주세요.");
        }
    }
}
