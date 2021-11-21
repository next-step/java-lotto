package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket extends AbstractLottoTicket {

    public LottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static LottoTicket from(List<Integer> args) {
        return new LottoTicket(args);
    }

    public Set<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableSet(this.lottoTicket);
    }

    public List<LottoNumber> sortLottoTicket() {
        List<LottoNumber> result = new ArrayList<>(this.lottoTicket);
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }
}
