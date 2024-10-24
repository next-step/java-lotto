package lotto.domain.numbergenerator;

import lotto.domain.LottoBuyDetails;

public class LottoNumberGeneratorFactory {
    private LottoBuyDetails lottoBuyDetails;
    public LottoNumberGeneratorFactory(LottoBuyDetails lottoBuyDetails) {
        this.lottoBuyDetails = lottoBuyDetails;
    }
    public  LottoNumberGenerator createGenerator() {
        if (lottoBuyDetails.isMix()) {
            return new MixLottoNumberGenerator(lottoBuyDetails);
        }
        if (lottoBuyDetails.isAuto()) {
            return new AutoLottoNumberGenerator(lottoBuyDetails.getAutoLottoCount());
        }
        return new ManualLottoNumberGenerator(lottoBuyDetails.getManualBuyDetails());
    }
}
