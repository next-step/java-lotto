package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(bonusNumber + "는 이미 당첨된 번호입니다.");
        }
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;

    }

    public LottoResult lottoMatchingResult(List<LottoNumbers> lottoTickets) {
        return new LottoResult(matchingLottoNumbers(lottoTickets));
    }

    private EnumMap<LottoRanking, Integer> matchingLottoNumbers(List<LottoNumbers> lottoTickets) {
        return new EnumMap<>(lottoTickets.stream()
                .map(this::filterMatchingNumbers)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (existing, replacement) -> existing + 1)));
    }

    private LottoRanking filterMatchingNumbers(LottoNumbers lottoTicket) {
        return LottoRanking.of(getMatchCount(lottoTicket), hasBonusNumber());
    }

    private int getMatchCount(LottoNumbers lottoTicket) {
        return lottoNumbers.contains(lottoTicket);
    }

    private boolean hasBonusNumber() {
        return lottoNumbers.contains(bonusNumber);
    }
}
