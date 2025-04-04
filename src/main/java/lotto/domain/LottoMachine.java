package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int PRICE_OF_LOTTO = 1_000;

    public Lottos buy (long money) {
        return this.buy(money, new ArrayList<>());
    }

    public Lottos buy (long money, List<String> manualLottoNumberInputs) {
        validate(money, manualLottoNumberInputs);

        List<LottoNumbers> lottos = new ArrayList<>();
        lottos.addAll(generateManualLottos(manualLottoNumberInputs));
        money = money - (PRICE_OF_LOTTO * manualLottoNumberInputs.size());
        lottos.addAll(generateAutoLottos(money));

        int manualLottoCount = manualLottoNumberInputs.size();
        int autoLottoCount = numberOfLottoTickets(money);
        return new Lottos(lottos, manualLottoCount, autoLottoCount);
    }

    private List<LottoNumbers> generateManualLottos(List<String> manualLottoNumberInputs) {
        List<LottoNumbers> lottos = new ArrayList<>();
        for (String manualLottoNumberInput : manualLottoNumberInputs) {
            lottos.add(LottoNumbers.toLottoNumber(manualLottoNumberInput));
        }
        return lottos;
    }

    private List<LottoNumbers> generateAutoLottos(long money) {
        List<LottoNumbers> lottos = new ArrayList<>();
        IntStream.range(0, numberOfLottoTickets(money))
                .forEach(i -> lottos.add(new LottoNumbers()));
        return lottos;
    }

    private void validate(long money, List<String> manualLottoNumberInputs) {
        if (money < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("최소 " + PRICE_OF_LOTTO + "원 이상 입력해야 합니다.");
        }

        if (hasManualLottoNumbers(manualLottoNumberInputs)
                && money < manualLottoNumberInputs.size() * PRICE_OF_LOTTO) {
                throw new IllegalArgumentException("수동 구매 총 가격이 구입금액보다 클 수 없습니다.");
        }
    }
    private boolean hasManualLottoNumbers(List<String> manualLottoNumberInputs) {
        return manualLottoNumberInputs != null && !manualLottoNumberInputs.isEmpty();
    }

    private int numberOfLottoTickets(long money) {
        return (int) money / PRICE_OF_LOTTO;
    }
}
