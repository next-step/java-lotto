package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;

public class LottoResultManager {

    private final Map<LottoPrice, Integer> lottoResult;

    public LottoResultManager() {
        this.lottoResult = new LinkedHashMap<>();
        for (LottoPrice price : LottoPrice.values()) {
            lottoResult.put(price, 0);
        }

    }

    public Map<LottoPrice, Integer> calculateLottoResult(List<LottoTicket> tickets,
        List<Integer> winningNumbers, int bonusNumber) {
        isBonusIncluded(winningNumbers, bonusNumber);
        LottoTicket winningTicket = LottoTicket.createTicket(winningNumbers);
        LottoNumber bonus = new LottoNumber(bonusNumber);
        for (LottoTicket ticket : tickets) {
            LottoPrice price = ticket.getPrice(winningTicket.getNumbers(), bonus);
            lottoResult.put(price, lottoResult.getOrDefault(price, 0) + 1);
        }
        return lottoResult;
    }

    public double calculateReturnRate(Map<LottoPrice, Integer> result, int purchaseAmount) {
        double winningMoney = calculateWinningMoney(result);
        return Math.round(winningMoney / purchaseAmount * 100.0) / 100.0;

    }

    private double calculateWinningMoney(Map<LottoPrice, Integer> result) {
        double winningMoney = 0;
        for (Map.Entry<LottoPrice, Integer> item : result.entrySet()) {
            winningMoney += item.getKey().getPrice() * item.getValue();
        }
        return winningMoney;
    }

    private void isBonusIncluded(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에 포함될 수 없습니다.");
        }
    }
}
