package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private static final int LOTTO_NUM_COUNT = 6;

    public static List<Integer> createWinningNumbers(String[] winningNumbers) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.valueOf(number));
        }

        Set<Integer> duplicateNumbers = new HashSet<>(numbers);
        if (duplicateNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("중복 당첨숫자 있음");
        }

        return numbers;
    }

    public static void checkWinning(List<Lotto> lottos, int number) {
        for (Lotto lotto : lottos) {
            lotto.incrMatchCount(number);
        }
    }

    public static LottoStatistics checkWinningLotto(List<Lotto> lottos) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        for (Lotto lotto : lottos) {
            lottoStatistics.incrPrizeCnt(LottoStatistics.Prize.getEnumNameByIntValue(lotto.getMatchCount()));
        }

        lottoStatistics.calculateProfit(lottos.size());

        return lottoStatistics;
    }
}
