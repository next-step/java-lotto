package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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
        int matchCount = (int) lottoNumbers.getLottoNumbers().stream()
                .filter(lottoNumber -> {
                    return winningLottoNumber.contains(lottoNumber);
                })
                .count();

        int bounsMatchCount = 0;

        if (lottoNumbers.contains(bounsNumber)) {
            bounsMatchCount = 1;
        }

        return LottoRank.getRankCondition(matchCount, bounsMatchCount);
    }

    public List<LottoRank> getWinnerLottos(List<LottoTicket> lottoTickets){
        return lottoTickets.stream()
                .map(lottoTicket -> getWinnerLotto(lottoTicket))
                .collect(Collectors.toList());
    }


    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumber.getLottoNumbers();
    }

    public int getBounsNumber() {
        return this.bounsNumber;
    }

    public boolean contains(int lottoNumber){
        return winningLottoNumber.contains(lottoNumber);
    }


}
