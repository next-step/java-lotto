package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class PurchasedLottos {

    private List<Lotto> lottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String lottoNumbersToString(){
        return this.lottos.stream()
                .map(Lotto::getStringLottoNumber)
                .collect(Collectors.joining("\n"));
    }

    public List<Long> correctNumbersPerEachLotto(List<Integer> winNumbers){
        return lottos.stream()
                .map(lotto -> lotto.correctNum(winNumbers))
                .collect(Collectors.toList());
    }

}
