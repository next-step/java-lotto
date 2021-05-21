package lotto.domain;

import java.util.List;

public class WinnerNumbers extends LottoTicket {

    private WinnerNumbers(List<LottoNumber> winnerNumbers) {
        super(winnerNumbers);
    }

    public static WinnerNumbers create(List<LottoNumber> winnerNumbers) {
        if (winnerNumbers.size() != NORMAL_COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 당첨번호의 갯수는 6개여야합니다.");
        }
        return new WinnerNumbers(winnerNumbers);
    }

    public LottoRank checkLottoTicket(LottoTicket lottoTicket) {
        List<LottoNumber> lottoNumbers = lottoTicket.getNumbers();

        int matchCount = (int) this.getNumbers().stream()
                .filter(ticketNumber -> lottoNumbers
                        .contains(ticketNumber))
                .count();

        return LottoRank.of(matchCount);
    }
}
