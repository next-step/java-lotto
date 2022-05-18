package Lotto.domain;

import java.util.List;

public class MyLotto extends Lotto{

    public MyLotto(List<Integer> numbers) {
        super(numbers);
    }

    public MyLotto(String winningNumbers) {
        super(winningNumbers);
    }

    public int findWinningLottoCnt(WinningLotto winningNumbers) {
        int cnt = 0;

        for (Number number : number) {
            cnt = findWinningLottoCnt(cnt, number, winningNumbers);
        }

        return cnt;
    }

    private int findWinningLottoCnt(int cnt, Number number, WinningLotto winningNumbers) {
        if (winningNumbers.getList().contains(number)) {
            cnt += 1;
        }

        return cnt;
    }

    public boolean isBonusNumber(WinningLotto winningLotto) {
        return number.contains(winningLotto.getBonusNumber());
    }

    public int getLottoNumber(int idx) {
        return number.get(idx).getNumber();
    }
}
