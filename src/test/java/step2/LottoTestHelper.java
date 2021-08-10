package step2;

import step2.lotto.*;
import step2.lotto.result.LottoResult;
import step2.lotto.result.LottoResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTestHelper {

    public static Lottos generateLottos(long count) {
        return LottoMachine.generateLottos(count);
    }

    public static Lotto generateFixedNumberLotto(List<Integer> numbers) {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        return new Lotto(lottoNumber);
    }

    public static LottoNumber generateLottoNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return new LottoNumber(numbers);
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

    public static LottoResult generateLottoResult(long countOfMatches) {
        LottoNumber winningNumber = generateLottoNumber();
        Lotto lotto = generateCountOfMatchesLotto(countOfMatches);
        return new LottoResult(winningNumber, lotto);
    }

    public static LottoResults generateLottoResults(long countOfMatches, long count) {
        List<LottoResult> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoNumber winningNumber = generateLottoNumber();
            Lotto lotto = generateCountOfMatchesLotto(countOfMatches);
            result.add(new LottoResult(winningNumber, lotto));
        }
        return new LottoResults(result);
    }

    private static Lotto generateCountOfMatchesLotto(long countOfMatches) {
        if (countOfMatches == Lotto.COUNT_OF_MATCHES_FIRST)
            return new Lotto(generateLottoNumber());

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_SECOND)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_THIRD)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_FOURTH)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));

        throw new IllegalStateException();
    }
}
