package lotto2.domain;

import java.util.List;

/**
 * 역할 - 당첨통계와 수익률을 계산하여 결과 (통계결과 객체) 를 반환한다.
 */
public class LottoPack {

    private int lottoPrice;
    private List<LottoTicket> lottoTickets;

    public LottoPack(int lottoPrice, List<LottoTicket> lottoTickets) {
        validate(lottoTickets);

        this.lottoPrice = lottoPrice;
        this.lottoTickets = lottoTickets;
    }

    private void validate(List<LottoTicket> lottoTickets) {
        if (lottoTickets != null && !lottoTickets.isEmpty()) {
            return;
        }

        throw new IllegalArgumentException("잘못된 숫자의 티켓을 입력하셨습니다.");
    }

    public int ticketCount() {
        return lottoTickets.size();
    }
}
