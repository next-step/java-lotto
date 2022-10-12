package lotto.domain;

import java.util.NavigableSet;

import static lotto.domain.LottoNumber.validateLottoNumber;

public class LottoTicket {

    private final NavigableSet<Integer> lottoTicket;

    public LottoTicket(NavigableSet<Integer> lottoTicket) {
        if (!validateLottoNumber(lottoTicket)) {
            throw new IllegalArgumentException("로또 번호가 올바르지 않습니다. 숫자 6자리를 입력해주세요. (사용자 입력:" + lottoTicket + " -> 샘플 예제:[3, 15, 18, 20, 25, 45])");
        }
        this.lottoTicket = lottoTicket;
    }

    public NavigableSet<Integer> lottoTicket() {
        return lottoTicket;
    }
}
