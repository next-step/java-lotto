package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.model.LottoRules;
import lotto.model.Price;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAuto {

    private static final LottoAuto lottoAuto = new LottoAuto();

    private LottoAuto() {
    }

    public static LottoAuto getInstance() {
        return lottoAuto;
    }

    public void play() {
        LottoRules lottoRules = new LottoRules();
        Price price= new Price(InputView.inputPrice());
        Count count = price.calculateCount();
        OutputView.printLottoCount(count.getCount());
        List<Lotto> lottos = createLottos(lottoRules, count);
        User user = new User(lottos);
        OutputView.printLottos(user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers(),InputView.inputBonusBall());
        user.setRanks(winningNumber);
        OutputView.printResult(user.getRanks(), user.getCount() * lottoRules.getLottoPrice());
    }

    private List<Lotto> createLottos(LottoRules lottoRules, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.getCount(); i++) {
            lottos.add(new Lotto(lottoRules.makeLottoNumbers()));
        }
        return lottos;
    }
}
