package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosFactory {
    public static Lottos createAuto(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(makeRandomLotto());
        }

        return new Lottos(lottoList);
    }

    private static Lotto makeRandomLotto() {
        List<LottoNumber> numbers = IntStream.rangeClosed(
                        LottoNumber.MINIMUM_LOTTO_NUMBER,
                        LottoNumber.MAXIMUM_LOTTO_NUMBER
                )
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new Lotto(Set.copyOf(numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE)));
    }

    public static Lottos createManualByStringList(List<String> lottoStringList) {
        return new Lottos(lottoStringList.stream()
                .map(Lotto::from)
                .collect(Collectors.toList()));
    }
}
