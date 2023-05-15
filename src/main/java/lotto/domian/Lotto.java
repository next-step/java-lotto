package lotto.domian;

import java.io.ObjectOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Lotto {

    public static final int PURCHASE_UNIT = 1000;
    private final Set<LottoNumber> lottoTicket;

    public Lotto(Set<LottoNumber> lottoTicket) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lottoTicket = new HashSet<>();
        for (int number : numbers) {
            lottoTicket.add(new LottoNumber(number));
        }
        return new Lotto(lottoTicket);
    }

    public int match(Lotto winNumber) {
        AtomicInteger count = new AtomicInteger(0);
        if (winNumber == null) {
            return count.intValue();
        }
        lottoTicket.stream()
                .forEach(lottoNumber ->
                            count.addAndGet(winNumber.countIfHave(lottoNumber)));

        return count.intValue();
    }

    private int countIfHave(LottoNumber lottoNumber) {
        if (haveNumber(lottoNumber)) {
            return 1;
        }
        return 0;
    }


    public boolean haveNumber(LottoNumber bonusNumber) {
        return lottoTicket.contains(bonusNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Set.copyOf(lottoTicket);
    }

    private void checkDuplicate(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

}
