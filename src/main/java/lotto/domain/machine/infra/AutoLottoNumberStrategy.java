package lotto.domain.machine.infra;

import lotto.domain.lotto.Lotteries;
import lotto.domain.machine.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static lotto.domain.Constant.*;

public class AutoLottoNumberStrategy implements LottoNumberStrategy {
    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    private final int autoCount;

    public AutoLottoNumberStrategy(int autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public Lotteries get() {
        List<List<Integer>> lottoByAuto = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Collections.shuffle(lottoNumbers);
            List<Integer> selectedLottoNum = new ArrayList<>(lottoNumbers).subList(ZERO_INDEX, LOTTO_NUM_COUNT_LIMIT);
            selectedLottoNum.sort(comparingInt(Integer::intValue));
            lottoByAuto.add(selectedLottoNum);
        }
        return Lotteries.of(lottoByAuto);
    }
}
