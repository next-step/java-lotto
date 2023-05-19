package lotto.domian;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    public static final int PURCHASE_UNIT = 1000;
    private static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoTicket;

    public Lotto(Set<LottoNumber> lottoTicket) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public Lotto(List<Integer> numbers) {
        this(toSet(numbers));
    }

    private static Set<LottoNumber> toSet(List<Integer> numbers) {
        Set<LottoNumber> lottoTicket = new HashSet<>();
        for (int number : numbers) {
            lottoTicket.add(LottoNumber.of(number));
        }
        return lottoTicket;
    }

    public int match(Lotto winNumber) {
        return (int)lottoTicket.stream()
                .filter(winNumber::haveNumber)
                .count();
    }

    public boolean haveNumber(LottoNumber bonusNumber) {
        return lottoTicket.contains(bonusNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Set.copyOf(lottoTicket);
    }

    private void checkDuplicate(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return Objects.equals(lottoTicket, lotto.lottoTicket);
    }

    @Override
    public int hashCode() {
        return lottoTicket != null ? lottoTicket.hashCode() : 0;
    }
}
