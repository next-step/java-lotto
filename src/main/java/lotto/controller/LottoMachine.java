package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.util.LottoNumberParser;
import lotto.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int PRICE_PER_LOTTO = 1000;
    private final LottoPrice lottoPrice;
    private LottoCount totalCount;
    private LottoCount manualCount;
    private LottoCount inputCount;
    private List<LottoNumbers> manualLottoNumbers;

    public LottoMachine(String price) {
        this(new LottoPrice(price), new LottoCount(price, PRICE_PER_LOTTO), new LottoCount(0));
    }

    public LottoMachine(String price , String manualCount) {
        this(new LottoPrice(price), new LottoCount(price, PRICE_PER_LOTTO), new LottoCount(manualCount));
    }

    public LottoMachine(LottoPrice lottoPrice, LottoCount totalCount,  LottoCount manualCount) {
        if (!validateLottoCount(totalCount, manualCount)) {
            throw new RuntimeException("유효하지 않은 입력입니다");
        }

        this.lottoPrice = lottoPrice;
        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.inputCount = new  LottoCount(0);
        this.manualLottoNumbers = new ArrayList<>();
    }

    public boolean isManualNumberInputEnd() {
        return this.inputCount.equals(this.manualCount);
    }

    public void getManualLottoNumbers(String lottoNumbers) {
        this.inputCount = this.inputCount.increase();
        manualLottoNumbers.add(new LottoNumbers(lottoNumbers));
    }

    public Lotto generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < lottoPrice.count(); i++) {
            lottoNumbersList.add(new LottoNumbers(LottoNumberParser.parse(RandomNumbersGenerator.randomNumbers())));
        }

        return new Lotto(lottoPrice, lottoNumbersList);
    }

    private static boolean validateLottoCount(LottoCount total, LottoCount manual) {
        return total.isBiggerOrSameThan(manual);
    }
}
