package lotto.domain;

import lotto.constant.Rank;
import lotto.exception.InvalidManualLottoNumberCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final Lottos lottos;

    public LottoGame(int purchaseAmount, List<String> manualLottoNumbers) {
        if (manualLottoNumbers.size() > purchaseCount(purchaseAmount)) {
            throw new InvalidManualLottoNumberCount(purchaseCount(purchaseAmount));
        }

        List<Lotto> lottos = manualLottoNumbers.stream()
                .map(LottoNumbers::new)
                .map(Lotto::valueOf)
                .collect(Collectors.toList());

        while (lottos.size() < purchaseCount(purchaseAmount)) {
            lottos.add(Lotto.createAutoLotto());
        }
        this.lottos = new Lottos(lottos);
        this.purchaseAmount = purchaseAmount;
    }

    private int purchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void confirmLottos(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        lottos.confirmAll(lastWinningNumbers, bonusNumber);
    }

    public double calculateProfitRate() {
        return (double) lottos.calculateTotalWinPrice() / (double) purchaseAmount;
    }

    public Lottos lottos() {
        return lottos;
    }

    public int countMatchResult(Rank rank) {
        return lottos.countMatchResult(rank);
    }
}
