package com.lotto.model;

import com.lotto.util.LottoUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(int ticketSize) {
        lottoList = IntStream.range(0, ticketSize)
                .mapToObj((index) -> new Lotto(LottoUtil.extractRandomLottoNumbers()))
                .collect(Collectors.toList());
    }

    public Stream<Lotto> lottoStream() {
        return lottoList.stream();
    }
}
