package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerLotto;
import lotto.model.request.ReqLotto;
import lotto.service.gernerator.LottoNumbersGenerator;

import java.util.List;

public class LottoMachine {

    public static Lotto issueLotto(LottoNumbersGenerator lottoNumbersGenerator, ReqLotto reqLotto) {

        List<LottoNumbers> lottoNumbersList = lottoNumbersGenerator.bulkGenerateLottoNumbers(reqLotto);
        return new Lotto(lottoNumbersList);
    }

    public static WinnerLotto issueWinnerLotto(LottoNumbersGenerator lottoNumbersGenerator, ReqLotto reqLotto, int bonusNumber) {
        LottoNumbers lottoNumbers = lottoNumbersGenerator.generateLottoNumbers(reqLotto);
        return new WinnerLotto(lottoNumbers, LottoNumber.provideLottoNumber(bonusNumber));
    }
}
