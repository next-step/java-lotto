package com.lotto.domain;

import com.lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGame {

    private LottoMachine lottoMachine;
    private LottoView lottoView;

    public LottoGame() {
        this.lottoMachine = new LottoMachine();
        this.lottoView = new LottoView();
    }

    public void playLottoGame() {
        List<Lotto> extractedLotto = buyLotto();
        lottoView.outputExtractedLotto(extractedLotto);
    }

    public List<Lotto> buyLotto() {
        Integer countOfLotto = lottoView.inputPurchaseAmountOfLotto();

        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = lottoMachine.extractLottoNumbers();
            extractedLotto.add(new Lotto(extractedLottoNumbers));
        });

        return extractedLotto;
    }
}
