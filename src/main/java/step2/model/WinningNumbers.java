package step2.model;

import java.util.Set;

public class WinningNumbers {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        validateArguments(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateArguments(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개만 입력 가능합니다.");
        }

        if (bonusNumber == null) {
            throw new IllegalArgumentException("보너스 번호를 입력하세요.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 존재합니다.");
        }
    }

    private boolean isInvalidCount(Set<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static WinningNumbers create(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public LottoRank calculateMatchRank(LottoTicket lottoTicket) {
        int countOfMatch = lottoTicket.getMatchCount(this);
        boolean matchBonus = lottoTicket.containsNumber(bonusNumber);

        return LottoRank.valueOf(countOfMatch, matchBonus);
    }
}
