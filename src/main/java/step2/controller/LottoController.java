package step2.controller;

import step2.LottoMachine;

import java.util.*;

public class LottoController {
    private LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public List<Object[]> buyLotto(int fee) {
        return lottoMachine.buy(fee);
    }


}
