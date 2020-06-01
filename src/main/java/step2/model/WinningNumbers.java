package step2.model;

import java.util.List;

public class WinningNumbers {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private WinningNumbers(List<LottoNumber> numbers) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력 가능합니다.");
        }

        this.numbers = numbers;
    }

    private boolean isInvalidCount(List<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static WinningNumbers create(List<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers);
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public MatchResult calculateMatchResult(LottoTickets lottoTickets) {
        MatchResult matchResult = MatchResult.create();

        lottoTickets.getLottoTickets().forEach(lottoTicket -> {
            int matchCount = lottoTicket.getMatchCount(this);
            matchResult.plusCount(LottoRank.findRank(matchCount));
        });

        return matchResult;
    }
}
