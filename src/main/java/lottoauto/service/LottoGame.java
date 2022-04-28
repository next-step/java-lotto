package lottoauto.service;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoGenerator;

import java.util.*;

/**
 * - 금액을 입력 받아 로또 게임을 하는 클래스를 만든다.
 * - 1000원 금액에 맞는 로또 갯수만큼 로또 클래스를 생성한다.
 * - 당첨 로또를 생성한다.
 * - 당첨 통계를 출력한다.
 */
public class LottoGame {
    private final int money;
    private final int lottoCount;
    private final List<Lotto> lottos = new ArrayList<>();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public LottoGame(int money) {
        if(money < Lotto.PRICE) {
            throw new IllegalArgumentException("로또를 살 수 없습니다.");
        }
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> all() {
        return Collections.unmodifiableList(lottos);
    }

    public void start() {
        for (int i = 0; i < lottoCount; i++) {
             lottos.add(new Lotto(lottoGenerator.makeLotto()));
        }
    }
}
