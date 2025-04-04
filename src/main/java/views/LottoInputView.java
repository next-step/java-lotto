package views;

import step1.Tokens;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.LottoCount;

import java.util.ArrayList;
import java.util.List;

import static views.InputView.*;

public class LottoInputView {

    public static LottoContainer manualLottoInput(LottoCount manualLottoCount) {
        String query = "수동으로 구매할 번호를 입력해 주세요.";
        String delimiter = ",";

        List<Lotto> lottoList = generateLottosFromInput(manualLottoCount.value(), query, delimiter);
        return new LottoContainer(lottoList);
    }

    public static LottoCount createManualLottoCountWithQuery(LottoCount totalLottoCount) {
        LottoCount lottoCount = null;
        while (lottoCount == null) {
            int manualLottoCount = InputView.promptForInteger("수동으로 구매할 로또 수를 입력해 주세요.");
            lottoCount = checkAndCreateLottoCount(totalLottoCount, manualLottoCount);
        }
        return lottoCount;
    }

    private static List<Lotto> generateLottosFromInput(int manualLottoCount, String query, String delimiter) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(promptForIntegerList(query, delimiter)));

        for (int i = 0; i < manualLottoCount - 1; i++) {
            Lotto lotto = generateLotto(delimiter);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static Lotto generateLotto(String delimiter) {
        Tokens tokens = tokenize(inputWithoutExpression(), delimiter);
        return new Lotto(convertTokensToIntegers(tokens));
    }

    private static LottoCount checkAndCreateLottoCount(LottoCount totalLottoCount, int lottoCount) {
        LottoCount lottoCountToCreate = new LottoCount(lottoCount);
        if (lottoCountToCreate.isBiggerThan(totalLottoCount)) {
            System.out.println("수동으로 구매할 로또 수가 전체 로또 수보다 많을 수 없습니다.");
            return null;
        }
        return lottoCountToCreate;
    }
}
