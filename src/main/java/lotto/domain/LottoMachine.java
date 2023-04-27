package lotto.domain;

import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public int calculateUnitCount(Amount amount) {
        return amount.calculateUnitCount(LOTTO_PRICE);
    }

    /**
     * 돈을 받으면 로또를 만들어주는 책임은 로또 기계에 있다 판단하여 해당로직 작성
     */
    public LottoBundle makeLottos(Amount amount, List<String> manualNumbers) {
        checkLottoQuantity(amount.calculateUnitCount(LOTTO_PRICE), manualNumbers.size());

        return new LottoBundle(manualNumbers, amount.calculateUnitCount(LOTTO_PRICE));
    }

    private void checkLottoQuantity(int totalCount, int manualCount) {
        if (totalCount < manualCount) {
            throw new IllegalArgumentException("이 금액으로 살 수 있는 로또 갯수를 초과하였습니다.");
        }
    }

    public WinningBall winningBall(String winningNumbers, int bonusBallNumber) {
        return new WinningBall(this.winningLotto(winningNumbers), this.bonusBall(bonusBallNumber));
    }

    private Lotto winningLotto(String winningNumbers) {
        return Lotto.winningLotto(winningNumbers);
    }

    private LottoNumber bonusBall(int bonusBallNumber) {
        return new LottoNumber(bonusBallNumber);
    }

    public WinningStat winningStat(Lottos lottos, WinningBall winningBall) {
        return lottos.rating(winningBall);
    }
}
