package lotto.domain;


import java.util.List;

import java.util.stream.Collectors;

public class LottoList {

    private final List<Lotto> lottos;

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottoTextList(){
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public int size(){
        return lottos.size();
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }


}
