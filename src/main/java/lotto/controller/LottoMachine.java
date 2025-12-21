package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.util.LottoNumberParser;
import lotto.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine implements LottoGenerator {
    private static final int PRICE_PER_LOTTO = 1000;
    private LottoCount totalCount;
    private LottoCount manualCount;
    private LottoCount inputCount;
    private List<LottoNumbers> lottoNumbersList;

    public LottoMachine(String price , String manualCount) {
        this(new LottoCount(price, PRICE_PER_LOTTO), new LottoCount(manualCount));
    }

    public LottoMachine(LottoCount totalCount,  LottoCount manualCount) {
        if (!validateLottoCount(totalCount, manualCount)) {
            throw new RuntimeException("유효하지 않은 입력입니다");
        }

        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.inputCount = new LottoCount(0);
        this.lottoNumbersList = new ArrayList<>();
    }

    public boolean isManualNumberInputEnd() {
        return this.inputCount.equals(this.manualCount);
    }

    public void getManualLottoNumbers(String lottoNumbers) {
        this.inputCount = this.inputCount.increase();
        lottoNumbersList.add(new LottoNumbers(lottoNumbers));
    }

    @Override
    public Lotto generate() {
        LottoCount autoCount = this.totalCount.diff(this.manualCount);

        for (int i = 0; !autoCount.isCountSame(i); i++) {
            this.lottoNumbersList.add(new LottoNumbers(LottoNumberParser.parse(RandomNumbersGenerator.randomNumbers())));
        }

        return new Lotto(this.lottoNumbersList);
    }

    private static boolean validateLottoCount(LottoCount total, LottoCount manual) {
        return total.isBiggerOrSameThan(manual);
    }
}
