package lotto.domian;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    public static final int PURCHASE_UNIT = 1000;
    private final Set<LottoNumber> lottoTicket;

    public Lotto(Set<LottoNumber> lottoTicket) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public static Lotto of(Integer... numbers) {
        Set<LottoNumber> lottoTicket = new HashSet<>();
        for (int number : numbers) {
            lottoTicket.add(new LottoNumber(number));
        }
        return new Lotto(lottoTicket);
    }

    public int match(Lotto winNumber) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoTicket) {
            count += winNumber.countIfHave(lottoNumber);
        }
        return count;
    }

    private int countIfHave(LottoNumber lottoNumber) {
        if (isHaveWinNumber(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isHaveWinNumber(LottoNumber winLottoNumber) {
        return lottoTicket.contains(winLottoNumber);
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
