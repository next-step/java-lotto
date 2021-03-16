package study.lotto.controller;

import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame() {
        this.lottos = new Lottos();
    }
    // 로또 구매 (로또 한 게임 생성)
    public Lottos buyLotto(RequestMoney money) {
        lottos.makeLotto(money);
        return lottos;
    }
}
