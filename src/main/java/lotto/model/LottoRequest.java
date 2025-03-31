package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {

    public static final int LOTTO_PRICE = 1000;

    private int money;
    private List<Lotto> manuelLottos;

    public LottoRequest(int money, List<String> manuelLottoStrs) {

        this.money = money;
        this.manuelLottos = manuelLottoStrs
                .stream()
                .map(str -> List.of(str.split(",")))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }


    protected int buyChance() {
        return money / LOTTO_PRICE;
    }

    public LottoWallet buy() {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumberGenerator());

        int size = buyChance();
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manuelLottos);
        for (int i = 0; i < size - manuelLottos.size(); i++) {
            lottos.add(lottoGenerator.generate());
        }

        return new LottoWallet(lottos);
    }
}


