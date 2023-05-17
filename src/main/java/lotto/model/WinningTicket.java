package lotto.model;

import java.util.List;

public class WinningTicket {
    private LottoTicket winningTicket;
    private LottoNumber bonusNumber;

    public WinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(List<LottoNumber> lottoNumbers) {
        int matchCount = winningTicket.matchLottoNumberCount(lottoNumbers);
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return Rank.findByCount(matchCount, matchBonus);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.winningTicket.getLottoNumbers();
    }

    private void validate(LottoNumber bonusNumber) {
        if (this.winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 6개의 당첨번호와 같을 수 없습니다.");
        }
    }
}
