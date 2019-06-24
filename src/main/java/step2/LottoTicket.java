package step2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    static final String ALERT_NUMBER_OVERLAP = "중복된 로또 번호가 존재합니다.";
    private final List<Integer> lottoTicket;

    LottoTicket(List<Integer> lottoTicket) {
        validationNumberOverlap(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validationNumberOverlap(List<Integer> lottoTicket) {
        Set<Integer> overlapCheckSet = new HashSet<>(lottoTicket);
        if (overlapCheckSet.size() != LottoTicketGenerator.BASIC_LOTTO_SIZE) {
            throw new IllegalArgumentException(ALERT_NUMBER_OVERLAP);
        }
    }

    public List<Integer> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
