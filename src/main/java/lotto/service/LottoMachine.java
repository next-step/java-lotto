package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.model.request.ReqLotto;
import lotto.service.gernerator.LottoNumbersGenerator;

import java.util.List;

public class LottoMachine {

    public static Lotto issueLotto(LottoNumbersGenerator lottoNumbersGenerator, ReqLotto reqLotto) {

        List<LottoNumbers> lottoNumbersList = lottoNumbersGenerator.generateLottoNumbers(reqLotto);
        return new Lotto(lottoNumbersList);
    }

}
