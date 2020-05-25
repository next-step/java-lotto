package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private static final int LOTTO_SALE_PRICE = 1000;

    private final int purchaseCount;
    private List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();

    public LottoGame() {
        this.purchaseCount = 0;
    }

    public LottoGame(int purchaseAmount) {
        validateLottoGame(purchaseAmount);

        this.purchaseCount = purchaseAmount / LOTTO_SALE_PRICE;
    }

    private void validateLottoGame(int purchaseAmount) {
        if (purchaseAmount < LOTTO_SALE_PRICE) {
            throw new IllegalArgumentException("구입금액이 1000원 이상 이어야 합니다.");
        }
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }

    public List<LottoNumbers> createAutoLottoNumbers() {
        List<LottoNumbers> autoLottoNumbers = Stream.generate(LottoNumbersFactory::createAutoLottoNumbers)
                .limit(this.purchaseCount)
                .collect(Collectors.toList());
        this.lottoNumbersGroup.addAll(autoLottoNumbers);

        return copyLottoNumbers(autoLottoNumbers);
    }

    private List<LottoNumbers> copyLottoNumbers(List<LottoNumbers> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumbers::clone)
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> createManualLottoNumbers(List<String> manualNumbers) {
        List<LottoNumbers> manualLottoNumbers = manualNumbers.stream()
                .map(LottoNumbersFactory::createManualLottoNumbers)
                .collect(Collectors.toList());
        this.lottoNumbersGroup.addAll(manualLottoNumbers);

        return copyLottoNumbers(manualLottoNumbers);
    }

    public LottoMatchResult calculateMatchCount(LottoNumbers lastWinLottoNumbers, int bonusNumber) {
        LottoMatchResult lottoMatchResult = LottoMatchResult.newInstance();

        this.lottoNumbersGroup.forEach(lottoNumbers -> {
            LottoMatch lottoMatch = LottoMatch.findByCount(lottoNumbers.getMatchCount(lastWinLottoNumbers),
                    lottoNumbers.isMatchNumber(bonusNumber));
            lottoMatchResult.increaseMatchCount(lottoMatch);
        });

        return lottoMatchResult;
    }
}
