package lotto;

import lotto.service.LottoNumberPicker;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoNum , LottoNumberPicker picker) {
        this.lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoNum ; i ++){
            List<Integer> lotto = picker.pick();
            this.lottos.add(new Lotto(lotto));
        }
    }
}