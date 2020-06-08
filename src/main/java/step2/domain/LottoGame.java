package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private UserPrice userPrice;
    private List<UserLotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = new UserPrice(userPrice);
        lottos = new ArrayList<>();
        lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    public void run() throws IllegalArgumentException {
        lottos = lottoGenerator.generateLottos(userPrice);
    }

    public LottoGameResultDto getGameResult(Lotto winningLotto, int bonusNumber)
        throws IllegalArgumentException {

        winningLotto.validateWinningNumbers();

        return new LottoGameResult().getResult(lottos, winningLotto, userPrice, bonusNumber);
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }
}
