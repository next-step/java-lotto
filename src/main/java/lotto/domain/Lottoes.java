package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {

    private final PurchaseAmount totalAmount;
    private final List<LottoNumbers> manualLotto;
    private final List<LottoNumbers> autoLotto;

    public Lottoes(PurchaseAmount purchaseAmount, List<String> manualLotto) {

        this.totalAmount = purchaseAmount;
        this.manualLotto = new LottoNumberGenerator().create(manualLotto);
        this.autoLotto = new LottoNumberGenerator().create(getAutoLottoAmount());
    }

    private int getAutoLottoAmount() {
        return totalAmount.minus(this.manualLotto.size() * PurchaseAmount.PRICE);
    }

    public List<LottoNumbers> getManualLotto() {
        return Collections.unmodifiableList(manualLotto);
    }

    public List<LottoNumbers> getAutoLotto() {
        return Collections.unmodifiableList(autoLotto);
    }

    public List<LottoNumbers> getTotalLotto() {
        List<LottoNumbers> totalLotto = new ArrayList<>();
        totalLotto.addAll(manualLotto);
        totalLotto.addAll(autoLotto);
        return totalLotto;
    }

    public LottoGameResult getResult(WinningNumbers winningNumbers) {
        List<Rank> ranks = getTotalLotto().stream()
                .map(winningNumbers::getRank)
                .collect(Collectors.toList());

        return new LottoGameResult(new Ranks(ranks), this.totalAmount);
    }
}
