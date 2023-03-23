package lotto.domain;

import java.util.Set;

public class WinningLottoTicket {
    private final LottoTicket winningLottoNumber;
    private final LottoNumber bounsNumber;

    public WinningLottoTicket(LottoTicket winningLottoNumber, int bounsNumber) {
        LottoNumber bounsLottoNumber = LottoNumber.getLottoNumber(bounsNumber);
        vaildBounsNumber(winningLottoNumber, bounsLottoNumber);
        this.winningLottoNumber = winningLottoNumber;
        this.bounsNumber = bounsLottoNumber;
    }

    private void vaildBounsNumber(LottoTicket lottoTicket, LottoNumber bounsNumber) {
        if (lottoTicket.getLottoNumbers().contains(bounsNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복 에러");
        }
    }

    public LottoRank getWinnerLotto(LottoTicket lottoNumbers) {
        int matchCount = (int) lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> winningLottoNumber.contains(lottoNumber))
                .count();

        int bounsMatchCount = 0;

        if (lottoNumbers.contains(bounsNumber)) {
            bounsMatchCount = 1;
        }

        return LottoRank.getRankCondition(matchCount, bounsMatchCount);
    }

    public Set<LottoNumber> getWinningLottoNumbers() {
        return winningLottoNumber.getLottoNumbers();
    }

    public LottoNumber getBounsNumber() {
        return this.bounsNumber;
    }


}
