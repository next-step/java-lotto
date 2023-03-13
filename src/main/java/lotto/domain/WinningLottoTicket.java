package lotto.domain;

import java.util.List;

public class WinningLottoTicket {
    private final LottoTicket winningLottoNumber;
    private final int bounsNumber;

    public WinningLottoTicket(LottoTicket winningLottoNumber, int bounsNumber) {
        vaildBounsNumber(winningLottoNumber, bounsNumber);
        this.winningLottoNumber = winningLottoNumber;
        this.bounsNumber = bounsNumber;
    }

    private void vaildBounsNumber(LottoTicket lottoTicket, int bounsNumber) {
        if (lottoTicket.getLottoNumbers().contains(bounsNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복 에러");
        }
    }

    public LottoRank getWinnerLotto(LottoTicket lottoNumbers) {
        int condition = (int) lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> {
                    return this.winningLottoNumber.getLottoNumbers().contains(lottoNumber);
                })
                .count();

        int bounsCondition = 0;

        if (lottoNumbers.contains(bounsNumber)) {
            bounsCondition = 1;
        }

        return LottoRank.getRankCondition(condition, bounsCondition);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumber.getLottoNumbers();
    }

    public int getBounsNumber() {
        return this.bounsNumber;
    }


}
