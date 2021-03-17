package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = createLottoTicket();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
