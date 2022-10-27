package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public LottoNumber getBonusNumber() {
        return bonusNumber;
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
        System.out.println(lottoNumbers);
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lottoTicket.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    private boolean hasBonusNumber(LottoNumbers lottoTicket) {
        System.out.println("오잉 ? : " + lottoTicket.getLottoNumbers());
        return lottoTicket.getLottoNumbers().contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}
