package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;
import com.lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> availableLottoNumbers = Collections.unmodifiableList(makeAvailableLottoNumbers());

    private LottoExtractor shuffleLottoExtractor;
    private LottoExtractor manualLottoExtractor;
    private LottoView lottoView;

    public LottoMachine(LottoView lottoView, LottoExtractor shuffleLottoExtractor, LottoExtractor manualLottoExtractor) {
        this.shuffleLottoExtractor = shuffleLottoExtractor;
        this.manualLottoExtractor = manualLottoExtractor;
        this.lottoView = lottoView;
    }

    public List<Lotto> buyLotto() {
        Integer countOfLotto = this.lottoView.inputPurchaseAmountOfLotto();
        Integer countOfManualLotto = this.lottoView.inputCountOfManualLotto();

        validateManualLottoCount(countOfLotto, countOfManualLotto);
        Integer countOfAutomaticLotto = countOfLotto - countOfManualLotto;

        List<Lotto> extractedManualLotto = extractManualLotto(countOfManualLotto);
        List<Lotto> extractedAutomaticLotto = extractAutomaticLotto(countOfAutomaticLotto);

        this.lottoView.outputResultOfEachLottoCount(extractedAutomaticLotto.size(), extractedManualLotto.size());

        List<Lotto> extractedLotto = new ArrayList<>();
        extractedLotto.addAll(extractedManualLotto);
        extractedLotto.addAll(extractedAutomaticLotto);

        outPutExtractedLotto(extractedLotto);

        return extractedLotto;
    }

    private void validateManualLottoCount(Integer countOfLotto, Integer countOfManualLotto) {
        if (countOfLotto < countOfManualLotto) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 금액을 초과합니다.");
        }
    }

    private List<Lotto> extractAutomaticLotto(Integer countOfLotto) {
        return extractLotto(countOfLotto, this.shuffleLottoExtractor, LottoMachine.availableLottoNumbers);
    }

    private List<Lotto> extractManualLotto(Integer countOfLotto) {
        return extractLotto(countOfLotto, this.manualLottoExtractor, getManualLotto());
    }

    private List<Integer> getManualLotto() {
        String manualLotto = this.lottoView.inputManualLotto();
        return LottoViewHelper.manipulateInputLottoNumbers(manualLotto);
    }

    private List<Lotto> extractLotto(Integer countOfLotto, LottoExtractor lottoExtractor, List<Integer> availableLottoNumbers) {
        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = lottoExtractor.extractLottoNumbers(availableLottoNumbers);
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
