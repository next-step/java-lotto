package lotto.domain;

public class LottoTicket {

    public static final String NOT_FOUND_PRIZE_ERROR_MESSAGE = "prize 가 존재하지 않습니다.";
    private final LottoNumbers lottoNumbers;
    private final Prize prize;

    public LottoTicket(LottoNumbers lottoNumbers, Prize prize) {
        validatePrize(prize);
        this.lottoNumbers = lottoNumbers;
        this.prize = prize;
    }

    private void validatePrize(Prize prize) {
        if (prize == null) {
            throw new IllegalArgumentException(NOT_FOUND_PRIZE_ERROR_MESSAGE);
        }
    }

    public static LottoTicket of(LottoNumbers lottoNumbers, WinningNumbers winningNumbers) {
        return new LottoTicket(lottoNumbers, lottoNumbers.match(winningNumbers));
    }

    public Prize getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
