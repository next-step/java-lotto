package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumber bonusNumber;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER + "개의 로또 번호를 입력해 주세요.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this(lottoNumbers);
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(bonusNumber + "는 이미 당첨된 번호입니다.");
        }
        this.bonusNumber = bonusNumber;

    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public ArrayList<LottoRanking> matchingLottoNumbers(List<LottoNumbers> lottoTickets) {
        ArrayList<LottoRanking> rank = new ArrayList<>();
        for (LottoNumbers lottoTicket : lottoTickets) {
            rank.add(lottoMatchingResult(lottoTicket));
        }
        return rank;
    }

    private LottoRanking lottoMatchingResult(LottoNumbers lottoTicket) {
        return LottoRanking.of(filterMatchingNumbers(lottoTicket), hasBonusNumber(lottoTicket));
    }

    private int filterMatchingNumbers(LottoNumbers lottoTicket) {
        return (int) lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(LottoNumbers lottoTicket) {
        return lottoTicket.getLottoNumbers().contains(bonusNumber);
    }
}
