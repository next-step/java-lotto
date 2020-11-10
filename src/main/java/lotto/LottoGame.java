package lotto;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    public static final String INVALID_AMOUNT_ERR_MSG = "amount의 값은 음수가 될 수 없습니다.";

    private final View view;
    private final LottoService lottoService;

    public LottoGame(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void start() {
        int amount = getAmount();
        List<Lotto> boughtLottos = buyLottos(amount);
        if (boughtLottos.size() == 0) {
            return;
        }
        Lotto winningLotto = getWinningLotto();
        printStatistic(boughtLottos, winningLotto);
    }

    private int getAmount() {
        int amount = view.getAmount();
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERR_MSG);
        }
    }

    private List<Lotto> buyLottos(int amount) {
        List<Lotto> boughtLottos = lottoService.buyLottos(amount);
        view.printBoughtLottos(boughtLottos);
        return boughtLottos;
    }

    private Lotto getWinningLotto() {
        return new Lotto(view.getWinningNumbers());
    }

    private void printStatistic(List<Lotto> boughtLottos, Lotto winningLotto) {
        WinningStatistic winningStatistic = lottoService.getResult(winningLotto, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }
}
