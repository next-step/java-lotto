package controller;

import domain.Lotto;
import domain.LottoInfo;
import domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private LottoInfo lottoInfo;

    public LottoController(LottoInfo lottoInfo) {
        this.lottoInfo = lottoInfo;
    }

    public LottoController(int price) {
        lottoInfo = LottoInfo.from(price);
    }

    public Lottos initLottos() {
        List<Lotto> lottoList = IntStream
                .range(0, lottoInfo.getQuantity())
                .mapToObj(quantity -> {
                    Lotto lotto = new Lotto();
                    return lotto.getInstance();
                })
                .collect(Collectors.toList());
        return Lottos.from(lottoList);
    }

    public int getLottoQuantity() {
        return lottoInfo.getPrice() / 1000;
    }
}
