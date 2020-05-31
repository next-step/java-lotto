package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;
import com.lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> availableLottoNumbers = Collections.unmodifiableList(makeAvailableLottoNumbers());

    private LottoExtractor lottoExtractor;
    private LottoView lottoView;

    public LottoMachine(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void setLottoExtractor(LottoExtractor lottoExtractor) {
        this.lottoExtractor = lottoExtractor;
    }

    public List<Lotto> buyLotto() {
        Integer countOfLotto = this.lottoView.inputPurchaseAmountOfLotto();
        Integer countOfManualLotto = this.lottoView.inputCountOfManualLotto();

        validateManualLottoCount(countOfLotto, countOfManualLotto);
        Integer countOfAutomaticLotto = countOfLotto - countOfManualLotto;

        List<Lotto> extractedManualLotto = extractManualLotto(countOfManualLotto);
        List<Lotto> extractedAutomaticLotto = extractAutomaticLotto(countOfAutomaticLotto);

        this.lottoView.outputResultOfEachLottoCount(extractedAutomaticLotto.size(), extractedManualLotto.size());
        outPutExtractedLotto(extractedAutomaticLotto);

        List<Lotto> extractedLotto = new ArrayList<>();
        extractedLotto.addAll(extractedManualLotto);
        extractedLotto.addAll(extractedAutomaticLotto);

        return extractedLotto;
    }

    private void validateManualLottoCount(Integer countOfLotto, Integer countOfManualLotto) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 금액을 초과합니다.");
        }
    }

    private List<Lotto> extractAutomaticLotto(Integer countOfLotto) {
        setLottoExtractor(new ShuffleLottoExtractor());

        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = this.lottoExtractor.extractLottoNumbers(LottoMachine.availableLottoNumbers);
            extractedLotto.add(new Lotto(extractedLottoNumbers, 0));
        });

        return extractedLotto;
    }

    private List<Lotto> extractManualLotto(Integer countOfLotto) {
        this.lottoView.outputManualLottoMessage();
        setLottoExtractor(new ManualLottoExtractor());

        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            String manualLotto = this.lottoView.inputManualLotto();
            List<Integer> extractedLottoNumbers = LottoViewHelper.manipulateInputLottoNumbers(manualLotto);
            extractedLotto.add(new Lotto(extractedLottoNumbers, 0));
        });

        return extractedLotto;
    }

    private void outPutExtractedLotto(List<Lotto> extractedLotto) {
        this.lottoView.outputExtractedLotto(extractedLotto);
    }

    public LottoWinningNumbers inputWinningLottoNumbers() {
        String winningLottoNumbers = this.lottoView.inputWinningLottoNumbers();
        return LottoWinningNumbers.manipulateInputWinningLottoNumbers(winningLottoNumbers);
    }

    public LottoBonusBall inputLottoBonusBall() {
        Integer bonusBall = this.lottoView.inputBonusBall();
        return new LottoBonusBall(bonusBall);
    }

    private static List<Integer> makeAvailableLottoNumbers() {
        List<Integer> availableLottoNumbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(availableLottoNumbers::add);
        return availableLottoNumbers;
    }
}
