package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;

public class ConsoleLottoInputView implements LottoInputView{

    @Override
    public int amountInput() {
        return Integer.parseInt(InputView.input());
    }

    @Override
    public LastWinLotto lastWinLottoInput() {
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");

        String[] lottoNumbers = InputView.input().split(",");

        OutputView.print("보너스 번호를 입력해 주세요");

        return new LastWinLotto( new Lotto(lottoNumbers), LottoNumber.of(InputView.input()));
    }
}
