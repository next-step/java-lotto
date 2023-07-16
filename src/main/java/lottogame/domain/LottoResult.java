package lottogame.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    BigDecimal calculateEarningRate(List<LottoTicket> lottoTickets) {
        assertLottoTickets(lottoTickets);
        List<LottoPrize> lottoPrizes = toLottoPrizes(lottoTickets);
        BigDecimal totalMoney = BigDecimal.valueOf(LottoTicket.PURCHASABLE_UNIT)
            .multiply(BigDecimal.valueOf(lottoPrizes.size()));
        BigDecimal earnMoney = BigDecimal.valueOf(ZERO_MONEY);
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney = earnMoney.add(BigDecimal.valueOf(lottoPrize.getMoney()));
        }
        return earnMoney.divide(totalMoney, 2, RoundingMode.HALF_EVEN);
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
