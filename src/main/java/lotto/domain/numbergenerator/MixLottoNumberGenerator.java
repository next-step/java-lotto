package lotto.domain.numbergenerator;

import lotto.domain.LottoBuyDetails;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class MixLottoNumberGenerator implements LottoNumberGenerator {
    private LottoBuyDetails lottoBuyDetails;

    public MixLottoNumberGenerator(LottoBuyDetails lottoBuyDetails) {
        this.lottoBuyDetails = lottoBuyDetails;
    }


    @Override
    public List<LottoNumbers> generate() {
        List<LottoNumbers> newGeneratedNumbers = new ArrayList<>();
        newGeneratedNumbers.addAll(new ManualLottoNumberGenerator(lottoBuyDetails.getManualBuyDetails()).generate());
        newGeneratedNumbers.addAll(new AutoLottoNumberGenerator(lottoBuyDetails.getAutoLottoCount()).generate());
        return newGeneratedNumbers;
    }
}
