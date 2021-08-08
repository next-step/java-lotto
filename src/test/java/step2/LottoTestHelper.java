package step2;

import step2.lotto.Lotto;
import step2.lotto.LottoMachine;
import step2.lotto.LottoNumber;
import step2.lotto.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTestHelper {

    public static Lottos generateLottos(long count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(LottoMachine.generateLotto());
        }
        return new Lottos(result);
    }

    public static Lotto generateFixedNumberLotto(List<Integer> numbers) {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        return new Lotto(lottoNumber);
    }

    public static List<Integer> toIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static Lottos generateFixedNumberLottos(List<Integer> numbers) {
        Lotto lotto = LottoTestHelper.generateFixedNumberLotto(numbers);
        return new Lottos(Arrays.asList(lotto));
    }
}
