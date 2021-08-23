package com.lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Stream<Lotto> lottoStream() {
        return lottoList.stream();
    }

    public int size() {
        return lottoList.size();
    }
}
