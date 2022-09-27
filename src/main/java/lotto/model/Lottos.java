package lotto.model;

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

    public Integer getReward(Lotto winningNumber){
        return this.lottos.stream().map((lotto)-> MatchedNumber.getReward(lotto.getMatchedCount(winningNumber))).reduce(Integer::sum).orElse(0);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize(){
        return this.lottos.size();
    }
}