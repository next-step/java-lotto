package lottogame.domain;

import lottogame.service.LottoNumberGenerator;
import lottogame.service.LottoNumberGeneratorImpl;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final PurchaseAmount purchaseAmount;
    private final PurchaseCount purchaseCount;
    private final List<LottoGame> automaticNumbers;

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGeneratorImpl();

    public LottoTicket(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseCount = new PurchaseCount(purchaseAmount.getLottoCount());
        automaticNumbers = lottoNumberGenerator.generate(purchaseCount.getValue());
    }

    LottoTicket(PurchaseAmount purchaseAmount, List<LottoGame> automaticNumbers) {
        this.purchaseAmount = purchaseAmount;
        purchaseCount = new PurchaseCount(purchaseAmount.getLottoCount());
        this.automaticNumbers = automaticNumbers;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseCount;
    }

    public List<LottoGame> getAutomaticNumbers() {
        return Collections.unmodifiableList(automaticNumbers);
    }
}