package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {

    private final LottoRow winningNumber;
    private Map<Prize, Integer> winningLotto = new HashMap<>();

    public WinningNumber(List<LottoNumber> numbers) {
        this.winningNumber = new LottoRow(numbers);
    }

    public Map<Prize, Integer> calculate(LottoTicket lottoTicket) {
        for (LottoRow lottoRow : lottoTicket.getLottoRowList()) {
            containNum(lottoRow);
        }
        return winningLotto;
    }

    private void containNum(LottoRow lottoRow) {
        int containCount = lottoRow.isContainCount(winningNumber);

        Prize prize = Prize.valueOfCount(containCount);

        if (prize != Prize.NONE) {
            winningLotto.put(prize, winningLotto.getOrDefault(prize, 0) + 1);
        }
    }
}
