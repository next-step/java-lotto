package lotto.services;

import lotto.models.Lotto;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private final PickNumberService pickNumberService;

    public LottoService() {
        this.pickNumberService = new PickNumberService();
    }

    public List<Lotto> issueLotto(int payment, PickNumberStrategy strategy) {
        int count = payment / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < count) {
            lottos.add(Lotto.of(pickNumberService.pickNumbers(strategy)));
        }

        return lottos;
    }

}
