package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final Money LOTTO_PRICE = new Money(1000);
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static final List<Integer> lottoNumberSource = new ArrayList<Integer>() {{
        addAll(Arrays.asList(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,41,42,43,44,45
        ));
    }};

    public LottoMachine() {}

    public Lottos buyLottos(long inputMoney) {
        Money money = new Money(inputMoney);
        int numberOfLottos = money.countCanBuy(LOTTO_PRICE);

        return createLottos(numberOfLottos);
    }

    private Lottos createLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < numberOfLottos ; i++) {
            lottos.add(createLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Number> numbers = new ArrayList<>();
        Collections.shuffle(lottoNumberSource);

        for(int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            numbers.add(new Number(lottoNumberSource.get(i)));
        }

        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
