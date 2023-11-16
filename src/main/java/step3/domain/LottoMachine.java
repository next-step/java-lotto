package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int PRICE_PER_LOTTO = 1_000;
    private static final int LOTTO_SIZE = Lotto.LOTTO_SIZE;
    public static final int NUMBER_BOX_START_NUMBER = LottoNumber.NUMBER_BOX_START_NUMBER;
    public static final int NUMBER_BOX_END_NUMBER = LottoNumber.NUMBER_BOX_END_NUMBER;

    private static List<LottoNumber> rangeClosedNumberBox() {
        return IntStream.rangeClosed(NUMBER_BOX_START_NUMBER, NUMBER_BOX_END_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public Lottos play(int paidMoney, Lottos inputManualLottos) {
        validatePaidMoney(paidMoney, inputManualLottos);
        return mergeLottos(autoLottosWithGameCount(getGameCount(paidMoney, inputManualLottos)), inputManualLottos);
    }

    private void validatePaidMoney(int paidMoney, Lottos lottos) {
        if (paidMoney % PRICE_PER_LOTTO != 0 || paidMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("로또 구입 금액은 " + PRICE_PER_LOTTO + "원 단위로 가능합니다. (현재 금액: " + paidMoney + "원)");
        }
    }

    private int getGameCount(int paidMoney, Lottos inputManualLottos) {
        return moneyForAuto(paidMoney, inputManualLottos) / PRICE_PER_LOTTO;
    }

    private Lottos mergeLottos(Lottos autoLottos, Lottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.lottos());
        lottos.addAll(autoLottos.lottos());
        return new Lottos(lottos);
    }

    private int moneyForAuto(int paidMoney, Lottos inputLottos) {
        return paidMoney - (inputLottos.size() * PRICE_PER_LOTTO);
    }

    private Lottos autoLottosWithGameCount(int gameCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i< gameCount; i++){
            lottos.add(createLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumbers());
    }

    private List<LottoNumber> lottoNumbers() {
        List<LottoNumber> numberBox = rangeClosedNumberBox();
        Collections.shuffle(numberBox);
        return numberBox.subList(0, LOTTO_SIZE);
    }
}
