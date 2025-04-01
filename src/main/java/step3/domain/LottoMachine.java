package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    public static Lottos buyLotto(int money) {
        List<Lotto> lottoList = IntStream.rangeClosed(1, money / LOTTO_PRICE)
                .mapToObj(e -> createRandomLotto())
                .collect(Collectors.toList());
        return new Lottos(lottoList);
    }

    private static Lotto createRandomLotto() {
        LottoNums lottoNums = LottoNumSetGenerator.generateRandomSet();
        return new Lotto(lottoNums);
    }


    public static Lotto createLotto(String lottoNumsInput) {
        LottoNums lottoNums = LottoNumSetGenerator.generateSet(lottoNumsInput);
        return new Lotto(lottoNums);
    }
}
