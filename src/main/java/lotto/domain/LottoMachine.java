package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int PRICE_OF_LOTTO = 1_000;

    public Lottos buy(Money money) {
        return this.buy(money, new ArrayList<>());
    }

    public Lottos buy(Money money, List<String> manualLottoNumberInputs) {
        List<LottoNumbers> lottos = new ArrayList<>();

        List<LottoNumbers> manualLottos = generateManualLottos(money, manualLottoNumberInputs);
        lottos.addAll(manualLottos);

        List<LottoNumbers> autoLottos = generateAutoLottos(money);
        lottos.addAll(autoLottos);

        return new Lottos(lottos, manualLottos.size(), autoLottos.size());
    }

    private List<LottoNumbers> generateManualLottos(Money money, List<String> manualLottoNumberInputs) {
        List<LottoNumbers> lottos = new ArrayList<>();
        for (String manualLottoNumberInput : manualLottoNumberInputs) {
            lottos.add(LottoNumbers.toLottoNumber(manualLottoNumberInput));
        }
        money.buy(lottos.size());
        return lottos;
    }

    private List<LottoNumbers> generateAutoLottos(Money money) {
        int numberOfLottoTickets = money.buyAll();

        List<LottoNumbers> lottos = new ArrayList<>();
        IntStream.range(0, numberOfLottoTickets)
                .forEach(i -> lottos.add(new LottoNumbers()));
        return lottos;
    }

    private boolean hasManualLottoNumbers(List<String> manualLottoNumberInputs) {
        return manualLottoNumberInputs != null && !manualLottoNumberInputs.isEmpty();
    }

    private int numberOfLottoTickets(Money money) {
        return money.buyAll();
    }
}
