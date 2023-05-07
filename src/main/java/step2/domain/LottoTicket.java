package step2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        validInputNumber(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public LottoTicket(Set<Integer> numbers) {
        validInputNumber(numbers);
        lottoTicket = new ArrayList<>(numbers);
    }

    private static void validInputNumber(Collection<Integer> numbers) {
        if (numbers.size() != LottoCommonValue.DEFAULT_LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException(numbers + " : 입력한 숫자를 확인해 주세요");
        }
    }

    public boolean isContain(Integer number) {
        return this.lottoTicket.contains(number);
    }

    public long countMatchingNumbers(LottoTicket compareTarget) {
        return lottoTicket.stream()
                .filter(i -> compareTarget.isContain(i))
                .count();
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }

}
