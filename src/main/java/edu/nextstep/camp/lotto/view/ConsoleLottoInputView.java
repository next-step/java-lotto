package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static edu.nextstep.camp.lotto.view.OutputView.print;

public class ConsoleLottoInputView implements LottoInputView{

    @Override
    public int amountInput() {
        print("구입금액을 입력해 주세요.");
        return Integer.parseInt(InputView.input());
    }

    @Override
    public LastWinLotto lastWinLottoInput() {
        print("지난 주 당첨 번호를 입력해 주세요.");

        String[] lottoNumbers = InputView.input().split(",");

        OutputView.print("보너스 번호를 입력해 주세요");

        return new LastWinLotto( new Lotto(lottoNumbers), LottoNumber.of(InputView.input()));
    }

    @Override
    public int manualLottoCountInput() {
        print("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(InputView.input());
    }

    @Override
    public List<Lotto> manualLottoInput(int manualLottoCount) {
        print("수동으로 구매할 번호를 입력해 주세요.(',' 로 구분)");
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            lottoList.add(new Lotto(InputView.input().split(",")));
        }

        return lottoList;
    }
}
