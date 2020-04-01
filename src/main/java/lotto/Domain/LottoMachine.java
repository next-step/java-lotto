package lotto.Domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    Lottos lottos;

    public LottoMachine() {
        lottos = Lottos.init(new ArrayList<>());
    }

    public static LottoMachine init() {
        return new LottoMachine();
    }

    public Lottos buyAutoLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = makeLotto(makeAutoTargetNumber());
            lottos = buyLotto(lotto);
        }
        return lottos;
    }

    public int boughtLottoCount(int price) {
        lessThenOneLottoPriceException(price);
        return price / LOTTO_PRICE;
    }

    private void lessThenOneLottoPriceException(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("[" + price + " < " + LOTTO_PRICE + "] 금액이 부족합니다.");
        }
    }

    public Lottos buyLotto(Lotto lotto) {
        lottos.add(lotto);
        return lottos;
    }

    List<Integer> makeAutoTargetNumber() {
        return IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Lotto makeLotto(List<Integer> targetNumbers) {
        return Lotto.init(targetNumbers);
    }
}
