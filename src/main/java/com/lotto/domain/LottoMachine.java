package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> availableLottoNumbers = Collections.unmodifiableList(makeAvailableLottoNumbers());

    private LottoExtractor lottoExtractor;

    public LottoMachine(LottoExtractor lottoExtractor) {
        this.lottoExtractor = lottoExtractor;
    }

    private static List<Integer> makeAvailableLottoNumbers() {
        List<Integer> availableLottoNumbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(availableLottoNumbers::add);
        return availableLottoNumbers;
    }

    public List<Lotto> buyLotto(Integer countOfLotto) {
        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = lottoExtractor.extractLottoNumbers(LottoMachine.availableLottoNumbers);
            extractedLotto.add(new Lotto(extractedLottoNumbers, 0));
        });

        return extractedLotto;
    }
}
