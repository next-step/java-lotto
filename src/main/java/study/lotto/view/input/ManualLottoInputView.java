package study.lotto.view.input;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.dispenser.Lottos;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.*;

public class ManualLottoInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();

    private ManualLottoInputView() {}

    public static Lottos display(int numberOfManualLotto) {

        stringBuilder.append("수동으로 구매할 번호를 입력해 주세요.");
        printAndClear();

        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < numberOfManualLotto; count++) {
            List<String> parsedLottoNumbers = parseForLottoNumber(scanner.nextLine());
            Lotto manualLotto = LottoDispenser.manual(parsedLottoNumbers);
            lottos.add(manualLotto);
        }

        return new Lottos(lottos);
    }

}

