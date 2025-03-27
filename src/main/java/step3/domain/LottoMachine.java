package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    private static Lotto createRandomLotto() {
        LottoNumSet lottoNumSet = LottoNumSetGenerator.generateRandomSet();
        return new Lotto(lottoNumSet);
    }

    public static List<Lotto> buyLotto(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        return IntStream.rangeClosed(1, numberOfLottos)
                .mapToObj(e -> createRandomLotto())
                .collect(Collectors.toList());
    }

    public static Lotto createLotto(String lottoNumsInput) {
        LottoNumSet lottoNumSet = LottoNumSetGenerator.generateSet(lottoNumsInput);
        return new Lotto(lottoNumSet);
    }
}
