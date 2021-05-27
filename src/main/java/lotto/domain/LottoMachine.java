package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.intf.NumbersGenerator;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final Price buyPrice;
    private Lottos manualLottos;

    public LottoMachine(Price buyPrice) {
        this.buyPrice = buyPrice;
        this.manualLottos = new Lottos(new ArrayList<>());
    }

    public LottoMachine(int buyPrice) {
        this(new Price(buyPrice));
    }

    public LottoMachine(Price buyPrice, List<LottoNumbers> manualNumbers) {
        this.buyPrice = buyPrice;
        this.manualLottos = new Lottos(manualNumbers);
    }

    public LottoMachine(int buyPrice, List<LottoNumbers> manualNumbers) {
        this(new Price(buyPrice), manualNumbers);
    }

    public Lottos createLottos(NumbersGenerator numbersGenerator) {
        List<LottoNumbers> lottos = new ArrayList<>();
        addMenualLottoNumbers(lottos);
        addAutoLottoNumbers(lottos, numbersGenerator);
        return new Lottos(lottos);
    }

    private void addMenualLottoNumbers(List<LottoNumbers> lottos) {
        for (int i = 0; i < this.manualLottos.getSize(); i++) {
            lottos.add(this.manualLottos.getLottoNumbers(i));
        }
    }

    private void addAutoLottoNumbers(List<LottoNumbers> lottos, NumbersGenerator numbersGenerator) {
        long buyCount = (buyPrice.getPrice() / LOTTO_PRICE) - this.manualLottos.getSize();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(numbersGenerator.generateLottoNumbers());
        }
    }
}
