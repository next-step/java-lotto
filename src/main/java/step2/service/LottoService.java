package step2.service;

import step2.domain.Judge;
import step2.domain.Money;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoMachine;
import step2.domain.lotto.WinningLotto;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoListDTO;

public class LottoService {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final Judge judge = new Judge();

    private LottoList lottoList;

    public LottoListDTO buyLotto(int rawAmount) {
        Money money = new Money(rawAmount);
        lottoList = lottoMachine.buyAutoLotto(money);
        return lottoList.dto();
    }

    public JudgeResponseDTO getLottoResult(String rawNumberString, int rawBonusNumber) {
        WinningLotto winningLotto = new WinningLotto(rawNumberString, rawBonusNumber);
        return judge.calculateResult(lottoList, winningLotto);
    }

}
