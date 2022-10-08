package lotto.domain;

import lotto.util.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX;
import static lotto.domain.LottoNumber.MIN;

public class LottoFactory {
    private static final String DEFAULT_DELIMITER = ",";

    private LottoFactory() {
    }

    public static Lottos create(int autoCount, List<String> manualNumbers) {
        return createAutoLottos(autoCount).add(createManualLottos(manualNumbers));
    }

    private static Lottos createAutoLottos(int quantity) {
        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> createAutoLotto())
                .collect(Collectors.toList());

        return Lottos.create(lottos);
    }

    private static Lotto createAutoLotto() {
        List<LottoNumber> numbers = getRandomLottoNumbers().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return AutoLotto.create(numbers);
    }

    private static List<Integer> getRandomLottoNumbers() {
        Set<Integer> result = new HashSet<>();

        while (result.size() != LOTTO_SIZE) {
            result.add(getRandomNumber());
        }

        return new ArrayList<>(result);
    }

    private static int getRandomNumber() {
        return RandomGenerator.randomNumber(MIN, MAX);
    }

    private static Lottos createManualLottos(List<String> lottoNumbers) {
        List<Lotto> lottos = lottoNumbers.stream()
                .map(LottoFactory::createManualLotto)
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
