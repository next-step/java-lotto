package study.lotto.view.input;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.dispenser.Lottos;
import study.lotto.view.AbstractView;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoInputView extends AbstractView {

    private static final ManualLottoInputView instance = new ManualLottoInputView();

    public static ManualLottoInputView getInstance() {
        return instance;
    }

    public Lottos display(int numberOfManualLotto) {

        stringBuilder.append("수동으로 구매할 번호를 입력해 주세요.");
        printAndClear();

        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < numberOfManualLotto; count++) {
            String lottoNumbersDelimitedByComma = scanner.nextLine();
            List<LottoNumber> lottoNumbers = createLottoNumber(lottoNumbersDelimitedByComma);
            lottos.add(new Lotto(lottoNumbers));
        }

        return new Lottos(lottos);
    }

}

