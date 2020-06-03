package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private UserPrice userPrice;
    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = new UserPrice(userPrice);
        lottos = new ArrayList<>();
        lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    public void run() throws IllegalArgumentException {
        userPrice.validateUserPrice();
        lottos = lottoGenerator.generateLottos(userPrice);
    }

    public LottoGameResultDto getGameResult(String winningNumbers) throws IllegalArgumentException {

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        winningLotto.validateWinningNumbers();

        return new LottoGameResult(lottos, winningLotto, userPrice).getResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
