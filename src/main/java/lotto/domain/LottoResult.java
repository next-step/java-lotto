package lotto.domain;

import java.util.stream.Collectors;

import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoResult {
    private final LottoNumbers lottoNumbers;

    public LottoResult(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 null일 수 없습니다.");
        }

        if (lottoNumbers.size() != NUMBERS_IN_GAME) {
            throw new IllegalArgumentException(String.format("lottoNumbers의 크기(%s)는 %s여야 합니다.", lottoNumbers.size(), NUMBERS_IN_GAME));
        }
    }

    public LottoPrizes check(LottoTickets lottoTickets) {
        return new LottoPrizes(
                lottoTickets.getLottoTickets()
                        .stream()
                        .map(this::check)
                        .collect(Collectors.toList())
        );
    }

    private LottoPrize check(LottoTicket lottoTicket) {
        return LottoPrize.fromMatched(
                lottoNumbers.match(lottoTicket.getLottoNumbers())
        );
    }
}
