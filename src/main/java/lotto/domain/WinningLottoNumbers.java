package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 번호, 보너스 번호를 저장
 */
public class WinningLottoNumbers {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoTicket winningNumbers, LottoNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(LottoTicket winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복일 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public Map<Rank, Integer> calculateResult(List<LottoTicket> purchaseLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (LottoTicket lotto : purchaseLotto) {
            List<Integer> numbers = lotto.getNumbers();
            int matchCount = calculateMatchCount(numbers);
            boolean bonusMatch = containsBonusNumber(numbers);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private int calculateMatchCount(List<Integer> lottos) {
        return (int) lottos.stream()
                .filter(this.winningLotto.getNumbers()::contains)
                .count();
    }

    private boolean containsBonusNumber(List<Integer> lotto) {
        return lotto.contains(getBonusNumber());
    }
}
