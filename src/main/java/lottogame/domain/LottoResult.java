package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

class LottoResult {

    private static final int ZERO_MONEY = 0;

    private final LottoTicket lottoResultNumbers;
    private final LottoNumber lottoBonus;

    LottoResult(LottoTicket lottoResultNumbers, LottoNumber lottoBonus) {
        assertLottoBonus(lottoBonus, lottoResultNumbers);
        this.lottoResultNumbers = lottoResultNumbers;
        this.lottoBonus = lottoBonus;
    }

    private void assertLottoBonus(LottoNumber bonusNumber, LottoTicket lottoResultTicket) {
        if (lottoResultTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                String.format("bonusNumber \"%s\"는 lottoResultTicket\"%s\"의 원소와 중복될 수 없습니다.", bonusNumber,
                    lottoResultTicket));
        }
    }

    double calculateEarningRate(List<LottoTicket> lottoTickets) {
        assertLottoTickets(lottoTickets);
        List<LottoPrize> lottoPrizes = toLottoPrizes(lottoTickets);
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        int earnMoney = ZERO_MONEY;
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney += lottoPrize.getMoney();
        }
        return (double) earnMoney / (double) totalMoney;
    }

    private void assertLottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lottoTicket은 비어있으면 안됩니다.");
        }
    }

    List<LottoPrize> toLottoPrizes(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(this::toLottoPrize)
            .collect(Collectors.toList());
    }

    private LottoPrize toLottoPrize(LottoTicket lottoTicket) {
        return LottoPrize.of(lottoResultNumbers.getMatchedCount(lottoTicket),
            lottoTicket.contains(lottoBonus));
    }
}
