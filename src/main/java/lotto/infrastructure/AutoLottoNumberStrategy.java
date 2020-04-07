package lotto.infrastructure;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static lotto.domain.Constant.*;

public class AutoLottoNumberStrategy implements LottoNumberStrategy {
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private final int autoCount;

    public AutoLottoNumberStrategy(int autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public List<LottoNumbers> get() {
        List<LottoNumbers> lottoNumbersByAuto = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Collections.shuffle(lottoNumbers);
            List<LottoNumber> selectedLottoNum = new ArrayList<>(lottoNumbers).subList(ZERO_INDEX, LOTTO_NUM_COUNT_LIMIT);
            selectedLottoNum.sort(comparingInt(LottoNumber::intValue));
            lottoNumbersByAuto.add(new LottoNumbers(selectedLottoNum));
        }
        return lottoNumbersByAuto;
    }
}
