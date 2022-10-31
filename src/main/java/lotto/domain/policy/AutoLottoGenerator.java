package lotto.domain.policy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberFactory;

public class AutoLottoGenerator implements LottoPolicy {



    @Override
    public Lotto ball() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        while (list.size() != 6) {
            list.add(random.nextInt(LottoNumber.MAX_NUMBER - LottoNumber.MIN_NUMBER) + 1);
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
