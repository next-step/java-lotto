package step2.model;

import java.util.List;

public class WinningNumbers {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개만 입력 가능합니다.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 존재합니다.");
        }

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private boolean isInvalidCount(List<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static WinningNumbers create(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public MatchResult calculateMatchResult(LottoTickets lottoTickets) {
        MatchResult matchResult = MatchResult.create();

        lottoTickets.getLottoTickets().forEach(lottoTicket -> {
            int countOfMatch = lottoTicket.getMatchCount(this);
            boolean matchBonus = lottoTicket.containsNumber(bonusNumber);

            matchResult.plusCount(LottoRank.valueOf(countOfMatch, matchBonus));
        });

        return matchResult;
    }
}
