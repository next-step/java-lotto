package step3;


import step3.lotto.*;
import step3.lotto.result.LottoResult;
import step3.lotto.result.LottoResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static BonusNumber generateBonusNumber() {
        return new BonusNumber(7);
    }

    public static TotalLottoNumber generateTotalLottoNumber() {
        LottoNumber lottoNumber = generateLottoNumber();
        BonusNumber bonusNumber = generateBonusNumber();
        return new TotalLottoNumber(lottoNumber, bonusNumber);
    }

    public static Lottos generateFixedNumberLottos(List<Integer> numbers) {
        Lotto lotto = LottoTestHelper.generateFixedNumberLotto(numbers);
        return new Lottos(Arrays.asList(lotto));
    }

    public static LottoResult generateLottoResult(Rank rank) {
        TotalLottoNumber totalLottoNumber = generateTotalLottoNumber();
        Lotto lotto = generateLottoByPrize(rank);
        return new LottoResult(totalLottoNumber, lotto);
    }

    public static LottoResults generateLottoResults(Rank rank, long count) {
        List<LottoResult> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(generateLottoResult(rank));
        }
        return new LottoResults(result);
    }

    private static Lotto generateLottoByPrize(Rank rank) {

        if (rank == Rank.FIRST)
            return new Lotto(generateLottoNumber());

        if (rank == Rank.SECOND)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));

        if (rank == Rank.THIRD)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 9)));

        if (rank == Rank.FOURTH)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9)));

        if (rank == Rank.FIFTH)
            return new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));

        throw new IllegalStateException();
    }
}
