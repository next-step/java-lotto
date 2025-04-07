package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoTicket lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(lottoNumbers, bonusNumber);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this(new LottoTicket(numbers), LottoNumber.of(bonusNumber));
    }

    private void validateBonusNumber(LottoTicket numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank getLottoRank(LottoTicket ticket) {
        int matches = lottoNumbers.countMatches(ticket);
        boolean containsBonusNumber = ticket.contains(bonusNumber);
        return LottoRank.getRank(matches, containsBonusNumber);
    }
}
