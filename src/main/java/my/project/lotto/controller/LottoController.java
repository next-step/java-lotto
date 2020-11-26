package my.project.lotto.controller;

import my.project.lotto.domain.Ticket;
import my.project.lotto.domain.GameRecord;
import my.project.lotto.domain.Lotto;
import my.project.utils.IntUtils;

import java.util.List;

public class LottoController {
    private final Ticket info;
    private final Lotto lotto;

    public LottoController(int money) {
        IntUtils.isMoneyQualified(money);
        this.info = new Ticket(money);
        this.lotto = new Lotto();
    }

    public List<GameRecord> lotto() {
        return lotto.games(info);
    }

}
