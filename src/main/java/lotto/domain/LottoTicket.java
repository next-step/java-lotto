package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = createLottoTicket();
    }

    private List<Integer> createLottoTicket() {
        List<Integer> numbers = createLottoNumbers();

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                        .limit(6)
                        .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    private List<Integer> createLottoNumbers() {
        return Stream.iterate(LottoConstant.LOTTO_MIN_NUMBER, i -> i + 1)
                .limit(LottoConstant.LOTTO_MAX_NUMBER)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
