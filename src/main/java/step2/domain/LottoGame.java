package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;
import static step2.view.ErrorMessages.INVALID_WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

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
        userPrice.validateUserPrice();
        lottos = lottoGenerator.generateLottos(userPrice);
    }

    public LottoGameResultDto getGameResult(List<Integer> winningNumbers, int bonusNumber)
        throws IllegalArgumentException {

        Lotto winningLotto = new Lotto(winningNumbers);
        validateWinningNumbers(winningNumbers);

        return new LottoGameResult().getResult(lottos, winningLotto, userPrice, bonusNumber);
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers)
        throws IllegalArgumentException {

        if (CollectionUtils.size(winningNumbers) != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }
}
