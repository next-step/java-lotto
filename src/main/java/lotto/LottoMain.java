package lotto;

import lotto.domain.Lotto;
import lotto.domain.MatchPointRank;
import lotto.domain.UserInput;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.util.ListUtil.parseIntegerList;
import static lotto.util.StringUtil.split;
import static lotto.view.InputView.*;
import static lotto.view.OutView.printLottoList;
import static lotto.view.OutView.printResult;

public class LottoMain {
    public static void main(String[] args) {
        UserInput userInput = new UserInput(inputMoney(), inputPassiveNumber());

        LottoService lottoService = new LottoService(generateLottoList(userInput), new MatchPointRank());
        printLottoList(lottoService.getLottoList(), userInput);

        lottoService.playLotto(Arrays.asList(split(inputWinningNumbers())), inputBonusNumber());
        printResult(userInput, lottoService.getMatchPointMap());
    }

    private static List<Lotto> generateLottoList(UserInput userInput) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < userInput.getPassiveNumber(); i++) {
            List<String> numbers = Arrays.asList(split(inputPassiveNumbers()));
            Lotto lotto = new Lotto(parseIntegerList(numbers));
            lottoList.add(lotto);
        }
        for (int i = 0; i < userInput.getAutoCount(); i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
