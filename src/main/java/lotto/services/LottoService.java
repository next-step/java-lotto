package lotto.services;

import lotto.models.Lotto;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final PickNumberService pickNumberService;

    public LottoService(PickNumberService pickNumberService) {
        this.pickNumberService = pickNumberService;
    }

    public List<Lotto> issueLotto(int count) {
        PickNumberStrategy strategy = new NormalPickNumberStrategy();

        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < count) {
            lottos.add(Lotto.of(pickNumberService.pickNumbers(strategy)));
        }

        return lottos;
    }

}
