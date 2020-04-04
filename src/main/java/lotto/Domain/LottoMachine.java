package lotto.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    
    Lottos lottos;

    public LottoMachine() {
        lottos = Lottos.init(new ArrayList<>());
    }

    public static LottoMachine init() {
        return new LottoMachine();
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

    public Lottos c(int lottoCount) {
        Lottos lottos = Lottos.init(new ArrayList<>());
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = makeLotto(makeAutoTargetNumber());
            lottos = buyLotto(lotto);
        }
        return lottos;
    }

    public Lottos buyLotto(Lotto lotto) {
        lottos.add(lotto);
        return lottos;
    }

    List<Integer> makeAutoTargetNumber() {
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        return LOTTO_NUMBER_RANGE.subList(0, 6);
    }

    public Lotto makeLotto(List<Integer> targetNumbers) {
        return Lotto.init(targetNumbers);
    }
}
