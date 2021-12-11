package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoGameController {


    public LottoResult retrieveStatistics(Lottos lottos, List<Integer> winningLottoNumbers) {
        validateLottosAndWinningLottoNumbers(lottos, winningLottoNumbers);
        return lottos.lottoResult(new Lotto(new LottoNumbers(winningLottoNumbers)));
    }

    private void validateLottosAndWinningLottoNumbers(Lottos lottos, List<Integer> winningLottoNumbers) {
        validateLottos(lottos);
        validateWinningLottoNumbers(winningLottoNumbers);
    }

    private void validateLottos(Lottos lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("lottos가 null입니다.");
        }
    }

    private void validateWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        if (Objects.isNull(winningLottoNumbers)) {
            throw new IllegalArgumentException("winningLottoNumbers가 null입니다.");
        }
        if (winningLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("winningLottoNumbers의 사이즈가 0입니다.");
        }
    }
        return purchasePrice % Lotto.PRICE != 0;
    public Lottos purchaseLottos(PurchaseLottosRequest request) {
        return Lottos.from(request.purchasingLottoSize());
    }

    }
}
