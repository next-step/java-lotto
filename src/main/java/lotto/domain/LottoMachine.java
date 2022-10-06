package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX;
import static lotto.domain.LottoNumber.MIN;

public class LottoMachine {
    private static final String DEFAULT_DELIMITER = ",";

    private LottoMachine() {
    }

    public static Lottos createAutoLottos(int money) {
        int quantity = money / Lotto.PRICE;

        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> createAutoLotto())
                .collect(Collectors.toList());

        return Lottos.create(lottos);
    }

    private static Lotto createAutoLotto() {
        List<LottoNumber> numbers = RandomGenerator.randomNumbers(LOTTO_SIZE, MIN, MAX)
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return AutoLotto.create(numbers);
    }

    public static Lottos createManualLottos(List<String> lottoNumbers) {
        List<Lotto> lottos = lottoNumbers.stream()
                .map(LottoMachine::createManualLotto)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lotto createManualLotto(String lottoNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(lottoNumbers, DEFAULT_DELIMITER);

        List<LottoNumber> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String number = tokenizer.nextToken();
            numbers.add(LottoNumber.of(number));
        }

        return ManualLotto.create(numbers);
    }
}
