package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        if (winningLottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoStatistic draw(LottoBundle lottoBundle) {
        return new LottoStatistic(lottoBundle.export()
                .stream()
                .map(lottoTicket -> {
                    boolean bonus = lottoTicket.contains(bonusLottoNumber);
                    int matchNumberCount = lottoTicket.computeMatchCount(winningLottoNumbers);
                    return DrawResult.valueOf(bonus, matchNumberCount);
                })
                .collect(Collectors.toList()),
                lottoBundle.getTicketCount() * LottoTicket.PRICE);
    }
}
