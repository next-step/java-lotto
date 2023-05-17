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

    public Rank checkLottoTicket(LottoTicket winningTicket, int bonusNumber) {
        int count = (int) lottoTicket.stream()
                .filter(i -> winningTicket.isContain(i))
                .count();

        return Rank.toPrizeMoney(count, isContain(bonusNumber));
    }

    public String printTicket() {
        return lottoTicket.toString();
    }

}
