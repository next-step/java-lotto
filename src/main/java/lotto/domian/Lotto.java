package lotto.domian;

import java.util.HashSet;
import java.util.Set;
import java.util.function.LongToIntFunction;

public class Lotto {

    private final Set<LottoNumber> lottoTicket;

    public Lotto(Set<LottoNumber> lottoTicket) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static Lotto of(Integer... numbers) {
        Set<LottoNumber> lottoTicket = new HashSet<>();
        for (Integer number : numbers) {
            lottoTicket.add(new LottoNumber(number));
        }
        return new Lotto(lottoTicket);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoTicket) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (isHaveWinNumber(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isHaveWinNumber(LottoNumber lottoNumber) {
        return lottoTicket.contains(lottoNumber);
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
