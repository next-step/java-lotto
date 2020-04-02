package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.*;

public class LottoController {
    public static void main(String[] args) {
        Lotto lotto = LottoController.buyLotto();
        ResultView.printLotto(lotto.getLottoNumbers());
        List<LottoNumber> winningNumbers = InputView.getWinningNumbers();
        int match = LottoGame.match(lotto, new Lotto(winningNumbers));
        System.out.println(match);
    }

    public static Lotto buyLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        Random random = new Random();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(new LottoNumber(random.nextInt(45) + 1));
        }
        return new Lotto(new ArrayList<>(lottoNumbers));
    }
}
