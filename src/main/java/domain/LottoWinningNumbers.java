package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoWinningNumbers {
    private static final int RANGE_FROM = 1;
    private static final int RANGE_TO = 45;
    private final Lotto winningLotto;
    private final int bonusNumber;


    public LottoWinningNumbers(String[] winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.winningLotto = new Lotto(Arrays.stream(winningNumbers)
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList()));
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!(bonusNumber >= RANGE_FROM && bonusNumber <= RANGE_TO)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 사이에 있는 값만 허용 합니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
