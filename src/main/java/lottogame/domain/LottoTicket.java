package lottogame.domain;

import lottogame.service.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final PurchaseInfo purchaseInfo;
    private final List<LottoNumberPackage> automaticNumbers;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoTicket(PurchaseInfo purchaseInfo, LottoNumberGenerator lottoNumberGenerator) {
        this.purchaseInfo = purchaseInfo;
        this.lottoNumberGenerator = lottoNumberGenerator;
        automaticNumbers = this.lottoNumberGenerator.generate(purchaseInfo.getPurchaseCount().getValue());
    }

    LottoTicket(PurchaseInfo purchaseInfo, List<LottoNumberPackage> automaticNumbers) {
        this.purchaseInfo = purchaseInfo;
        this.automaticNumbers = automaticNumbers;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseInfo.getPurchaseAmount();
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseInfo.getPurchaseCount();
    }

    public List<LottoNumberPackage> getAutomaticNumbers() {
        return Collections.unmodifiableList(automaticNumbers);
    }
}