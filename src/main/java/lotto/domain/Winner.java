package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import static lotto.domain.Lotto.LOTTO_LENGTH;
import lotto.domain.result.LottoGameResult;

public class Winner {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    Winner(int num1, int num2, int num3, int num4, int num5, int num6, int bonusNumber) {
        this(Set.of(num1, num2, num3, num4, num5, num6), bonusNumber);
    }

    public Winner(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException("당첨 번호의 숫자는 보너스 넘버로 입력할 수 없습니다");
        }

        winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static Winner of(String numberString, int bonusNumber) {
        String[] numberArray = numberString.split(", ");

        Set<Integer> winningNumbers = new HashSet<>();
        for (int i = 0; i < LOTTO_LENGTH; ++i) {
            winningNumbers.add(Integer.parseInt(numberArray[i]));
        }

        return new Winner(winningNumbers, bonusNumber);
    }

    public LottoGameResult findWinners(Lottos lottos) {
        return lottos.matchNumbers(winningLotto, bonusNumber);
    }
}
