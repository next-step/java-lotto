package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER + "개의 로또 번호를 입력해 주세요.");
        }
        this.lottoNumbers = lottoNumbers;
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
        return LottoRanking.of(filterMatchingNumbers(lottoTicket));
    }

    private int filterMatchingNumbers(LottoNumbers lottoTicket) {
        List<Integer> match = lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumbers::contains)
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        return match.size();
    }
}
