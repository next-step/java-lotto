package lotto.ui;

import lotto.domain.AnswerSheet;
import lotto.domain.LottoList;
import lotto.match.LottoResult;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;


    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoList buyLotto(String inputMoney, String passiveLottoCount, List<String> lottoNumbers) {

        return lottoService.purchaseLotto(inputMoney,passiveLottoCount,lottoNumbers);
    }

    public AnswerSheet createAnswerSheet(String answerSheet, String bonusNumber) {
        return lottoService.getAnswerSheet(answerSheet,bonusNumber);
    }

    public LottoResult getResult(LottoList lottoList, AnswerSheet answerSheet) {
        return lottoService.createLottoResult(lottoList,answerSheet);
    }
}
