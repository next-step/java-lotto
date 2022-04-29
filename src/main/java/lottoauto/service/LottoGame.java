package lottoauto.service;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoGenerator;

import java.util.*;

/**
 * - 금액을 입력 받아 로또 게임을 하는 클래스를 만든다.
 * - 1000원 금액에 맞는 로또 갯수만큼 로또 클래스를 생성한다.
 * - 당첨 로또를 생성한다.
 * - 당첨 통계를 출력한다.
 * - 3개(5000원), 4개(50000원), 5개(1500000원), 6개(2000000000) 일치갯수(당첨금액) 별 결과를 통계 점수에 보여준다.
 * - 총 수익률을 계산한다.(로또게임 입력 금액 / 당첨금액)
 */
public class LottoGame {
    private final int money;
    private final int lottoCount;
    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;

    public LottoGame(int money) {
        if(money < Lotto.PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
        System.out.println(this.lottoCount+"개를 구매했습니다.");
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> all() {
        return Collections.unmodifiableList(lottos);
    }

    public void checkWinningLotto(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }

    public void buyLotto() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public void start() {
        for (Lotto lotto : lottos) {
            lotto.match(winningLotto);
        }
    }
}
