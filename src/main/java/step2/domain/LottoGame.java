package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private UserPrice userPrice;
    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = new UserPrice(userPrice);
        this.lottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    public void run() throws IllegalArgumentException {
        this.userPrice.validateUserPrice();
        this.lottos = lottoGenerator.generateLottos(this.userPrice);
    }

    public LottoGameResultDto getGameResult(String winningNumbers) throws IllegalArgumentException {

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        winningLotto.validateWinningNumbers();

        return new LottoGameResult(this.lottos, winningLotto, userPrice).getResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
