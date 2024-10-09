package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoAutoStrategy;
import step2.domain.LottoStrategy;
import step2.ui.LottoInputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final int LOTTO_AMOUNT = 1000;

    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();
        LottoStrategy strategy = new LottoAutoStrategy();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyAmount / LOTTO_AMOUNT; i++) {
            lottos.add(new Lotto(strategy));
        }
        System.out.println(lottos);
    }

}
