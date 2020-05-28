package com.cheolhyeonpark.lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    private final LottoInformation lottoInformation;
    private final AutoGenerator generator;

    public LottoManager(LottoInformation lottoInformation, AutoGenerator generator) {
        this.lottoInformation = lottoInformation;
        this.generator = generator;
        createLottoNumbers();
    }

    private void createLottoNumbers() {
        IntStream.range(0, lottoInformation.getGameCount())
                .mapToObj(i -> generator.generate())
                .forEach(lottoInformation::addLottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoInformation.getLottoNumbersList();
    }
}
