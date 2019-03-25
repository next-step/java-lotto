package lottogame.domain;

import lottogame.service.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final PurchaseInfo purchaseInfo;
    private final List<LottoNumberPackage> gameNumbers;

    public LottoTicket(PurchaseInfo purchaseInfo, List<LottoNumberPackage> manualNumbers, LottoNumberGenerator lottoNumberGenerator) {
        this.purchaseInfo = purchaseInfo;
        gameNumbers = manualNumbers;
        gameNumbers.addAll(lottoNumberGenerator.generate(purchaseInfo.getAutomaticCount()));
    }

    LottoTicket(PurchaseInfo purchaseInfo, List<LottoNumberPackage> gameNumbers) {
        this.purchaseInfo = purchaseInfo;
        this.gameNumbers = gameNumbers;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseInfo.getPurchaseAmount();
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseInfo.getPurchaseCount();
    }

    public List<LottoNumberPackage> getGameNumbers() {
        return Collections.unmodifiableList(gameNumbers);
    }
}