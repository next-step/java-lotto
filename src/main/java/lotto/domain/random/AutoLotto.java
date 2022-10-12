package lotto.domain.random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberFactory;
import lotto.domain.LottoPolicy;

public class AutoLotto implements LottoPolicy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public Lotto ball() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        while (list.size() != 6) {
            list.add(random.nextInt(MAX_NUMBER - MIN_NUMBER) + 1);
            list = list.stream().distinct()
                .collect(Collectors.toList());
        }
        List<LottoNumber> lottoNumbers = list.stream()
            .map(LottoNumberFactory::getLottoNumber)
            .sorted(Comparator.comparingInt(LottoNumber::value))
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
