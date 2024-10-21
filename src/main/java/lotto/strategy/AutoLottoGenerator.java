package lotto.strategy;

import lotto.domain.Lotto;
import lotto.vo.LottoCreateRequest;
import lotto.domain.Number;
import lotto.enumeration.LottoType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 6;
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    @Override
    public List<Lotto> generate(final LottoCreateRequest lottoCreateRequest) {
        Integer purchaseAmount = lottoCreateRequest.getPurchaseAmount();
        List<Lotto> manualLotto = lottoCreateRequest.getManualLotto();

        int countAutoLottos = purchaseAmount / LOTTO_PRICE - manualLotto.size();
        List<Lotto> autoLottos = generate(countAutoLottos);
        manualLotto.addAll(autoLottos);
        return manualLotto;
    }

    private List<Lotto> generate(final int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return lottos;
    }

    private Lotto generate() {
        List<Number> numbers = numbers();
        Collections.shuffle(numbers);
        List<Number> sixNumbers = sixNumbers(numbers);
        Collections.sort(sixNumbers);
        return new Lotto(LottoType.AUTO, sixNumbers);
    }

    private static List<Number> sixNumbers(final List<Number> numbers) {
        List<Number> result = new ArrayList<>();
        for (int i = FIRST_INDEX; i < LAST_INDEX; i++) {
            result.add(numbers.get(i));
        }
        return result;
    }

    private static List<Number> numbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = FIRST_NUMBER; i <= LAST_NUMBER; i++) {
            numbers.add(new Number(i));
        }
        return numbers;
    }
}
