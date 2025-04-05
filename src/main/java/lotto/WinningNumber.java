package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {

    private final LottoRow winningNumber;

    private final LottoNumber bonusNumber;
    private Map<Prize, Integer> winningLotto = new HashMap<>();

    public WinningNumber(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        this.winningNumber = new LottoRow(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<Prize, Integer> calculate(LottoTicket lottoTicket) {
        for (LottoRow lottoRow : lottoTicket.getLottoRowList()) {
            containNum(lottoRow);
        }

        return winningLotto;
    }

    private void containNum(LottoRow lottoRow) {
        int containCount = lottoRow.isContainCount(winningNumber);

        Boolean isContainBonus = lottoRow.isContainBonusNumber(bonusNumber);

        Prize prize = Prize.valueOfCount(containCount, isContainBonus);

        winningLotto.put(prize, winningLotto.getOrDefault(prize, 0) + 1);
    }
}
