package lotto.domain;

import lotto.utile.LottoValidator;
import lotto.utile.StringUtile;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static int buyLotto(int money) {
        LottoValidator.validateMoney(money);

        return money / 1000;
    }

    public static List<Lotto> pickUpLottos(int lotOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lotOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static int[] lottoResult(List<Lotto> lottoList, String winnerNumber) {
        int[] WinnerResult = new int[7];
        int[] winnerNumbers = StringUtile.convertStringToInt(winnerNumber);

        for (int i = 0; i < lottoList.size(); i++) {
            int numberOfMatches = lottoList.get(i).getNumberOfMatchesInLotto(winnerNumbers);
            WinnerResult[numberOfMatches] += 1;
        }
        return WinnerResult;
    }

}
