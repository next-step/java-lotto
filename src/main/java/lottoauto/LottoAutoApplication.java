package lottoauto;

import java.util.List;
import lottoauto.domain.LottoService;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningLotto;
import lottoauto.utils.ViewUtils.Input;
import lottoauto.utils.ViewUtils.Output;

public class LottoAutoApplication {

    public static void main(String[] args) {

        int amount = Input.amount();

        LottoService lottoService = new LottoService();

        Lottos lottos = lottoService.generateLottoNumber(amount);

        Output.lottos(lottos);
        List<Integer> winningNumbers = Input.winningNumber();
        int bonusNumber = Input.bonus();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult lottoResult = lottoService.compareWinningLottoNumber(lottos, winningLotto);

        Output.statistics(lottoResult, amount);

    }
}
