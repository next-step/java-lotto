package lotto.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    public static LottoMachine init() {
        return new LottoMachine();
    }

    public int boughtLottoCount(int price) {
        lessThenOneLottoPriceException(price);
        return price / Constants.LOTTO_PRICE;
    }

    private void lessThenOneLottoPriceException(int price) {
        if (price < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException("[" + price + " < " + Constants.LOTTO_PRICE + "] 금액이 부족합니다.");
        }
    }

    private List<Integer> makeAutoTargetNumber() {
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        return new ArrayList<>(LOTTO_NUMBER_RANGE.subList(0, 6));
    }

    public Lotto buyLotto(List<Integer> targetNumbers) {
        return Lotto.init(targetNumbers);
    }

    public Lottos purchaseAutoLotto(int lottoCount) {
        Lottos lottos = Lottos.init(new ArrayList<>());
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = buyLotto(makeAutoTargetNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lottos purchaseManualLotto(List<String> manualLotto) {
    }
}
