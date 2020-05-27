package com.lotto.domain;

import com.lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> availableLottoNumbers = Collections.unmodifiableList(makeAvailableLottoNumbers());

    private LottoExtractor lottoExtractor;
    private LottoView lottoView;

    public LottoMachine(LottoExtractor lottoExtractor, LottoView lottoView) {
        this.lottoExtractor = lottoExtractor;
        this.lottoView = lottoView;
    }

    public List<Lotto> buyLotto() {
        Integer countOfLotto = this.lottoView.inputPurchaseAmountOfLotto();
        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = this.lottoExtractor.extractLottoNumbers(LottoMachine.availableLottoNumbers);
            extractedLotto.add(new Lotto(extractedLottoNumbers, 0));
        });

        outPutExtractedLotto(extractedLotto);
        return extractedLotto;
    }

    private void outPutExtractedLotto(List<Lotto> extractedLotto) {
        this.lottoView.outputExtractedLotto(extractedLotto);
    }

    public LottoWinningNumbers inputWinningLottoNumbers() {
        String winningLottoNumbers = this.lottoView.inputWinningLottoNumbers();
        return LottoWinningNumbers.manipulateInputWinningLottoNumbers(winningLottoNumbers);
    }

    private static List<Integer> makeAvailableLottoNumbers() {
        List<Integer> availableLottoNumbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(availableLottoNumbers::add);
        return availableLottoNumbers;
    }
}
