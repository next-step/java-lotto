package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.view.ErrorMessages;

public class LottoGame {

    private int userPrice;
    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = userPrice;
        this.lottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    private void validateUserPrice(int userPrice) throws IllegalArgumentException {
        if (userPrice < 1000 || userPrice > 100000) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_USER_PRICE);
        }
    }

    public void run() throws IllegalArgumentException {
        validateUserPrice(userPrice);
        this.lottos = lottoGenerator.generateLottos(this.userPrice);
    }

    public LottoGameResultDto getGameResult(String winningNumbers) throws IllegalArgumentException {

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        winningLotto.validateWinningNumbers();

        drawLottos(winningLotto.getLottoNumbers());

        return new LottoGameResult(this.lottos, winningNumbers, userPrice).getResult();
    }

    private void drawLottos(List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
