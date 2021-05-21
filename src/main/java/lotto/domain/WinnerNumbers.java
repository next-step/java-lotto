package lotto.domain;

import java.util.List;

public class WinnerNumbers extends LottoTicket {

    private WinnerNumbers(List<LottoNumber> winnerNumbers) {
        super(winnerNumbers);
    }

    public static WinnerNumbers create(List<LottoNumber> winnerNumbers) {
        if (winnerNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨번호의 갯수는 6개여야합니다.");
        }
        return new WinnerNumbers(winnerNumbers);
    }

    public LottoRank matchCount(LottoTicket lottoTicket) {
        int matchCount = (int) this.numbers().stream()
                .filter(ticketNumber -> lottoTicket.numbers()
                        .contains(ticketNumber))
                .count();

        return LottoRank.of(matchCount);
    }
}
