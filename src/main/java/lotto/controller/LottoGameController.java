package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Numbers;

import java.util.List;
import java.util.Objects;

public class LottoGameController {

    public Lottos purchaseLottos(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return Lottos.from(purchaseLottoSize(purchasePrice));
    }

    public LottoResult retrieveStatistics(Lottos lottos, List<Integer> winningLottoNumbers) {
        validateLottosAndWinningLottoNumbers(lottos, winningLottoNumbers);
        return lottos.lottoResult(new Lotto(new Numbers(winningLottoNumbers)));
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

    private void validatePurchasePrice(int purchasePrice) {
        if (lessThanMinPrice(purchasePrice)) {
            throw new IllegalArgumentException(Lottos.MIN_LOTTO_PRICE + "원 이상의 가격이 전달되어야합니다.");
        }
        if (isInvalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(String.format("로또구입금액(%,d)은 %,d의 배수이어야합니다.", purchasePrice, Lotto.PRICE));
        }
    }

    private boolean lessThanMinPrice(int purchasePrice) {
        return purchasePrice < Lottos.MIN_LOTTO_PRICE;
    }

    private boolean isInvalidPrice(int purchasePrice) {
        return purchasePrice % Lotto.PRICE != 0;
    }

    private int purchaseLottoSize(int purchasePrice) {
        return purchasePrice / Lotto.PRICE;
    }
}
