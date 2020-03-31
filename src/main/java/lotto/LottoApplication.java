package lotto;

import lotto.domain.LottoResult;
import lotto.dto.LottoRequestDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoRequestDto lottoRequestDto = InputView.inputParameters();
        LottoShop lottoShop = new LottoShop();

        lottoShop.buyLotto(lottoRequestDto);
        ResultView.printLottoNumbers(lottoRequestDto, lottoShop.getLottoBundle());
        lottoRequestDto = InputView.inputLottoNumbers();

        LottoResult lottoResult = lottoShop.checkWinning(lottoRequestDto);
        ResultView.printResult(lottoResult);
    }
}
