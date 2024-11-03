package lotto.domain;

import java.util.List;
import java.util.Set;
public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private final int bonusNumber;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = -1;
    }

    public LottoTicket(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket generateWinningTicket(Set<Integer> winningNumbers, int bonusNumber) {
        LottoNumbers lottoNumbers = new LottoNumbers(List.copyOf(winningNumbers));
        return new LottoTicket(lottoNumbers, bonusNumber);
    }

    public static LottoNumbers generateRandomNumbers() {
        return LottoNumbers.generateLotto();
    }

    public int countMatchingNumbers(LottoTicket winningTicket) {
        return (int) lottoNumbers.getNumbers().stream()
                .filter(winningTicket.lottoNumbers.getNumbers()::contains)
                .count();
    }

    public boolean isBonusMatched(LottoTicket winningTicket) {
        return this.bonusNumber != -1 && this.bonusNumber == winningTicket.bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String getNumbersAsString() {
        return lottoNumbers.getNumbers().toString();
    }
}
