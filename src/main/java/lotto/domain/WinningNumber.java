package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class WinningNumber {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int WINNING_NUMBER_COUNT = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningNumber(List<LottoNumber> winningNumbers) {
        this(winningNumbers, getBonusLottoNumber(winningNumbers));
    }

    public WinningNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusLottoNumber = bonusNumber;
    }

    private static LottoNumber getBonusLottoNumber(List<LottoNumber> winningNumbers) {
        int bonusNumber = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                .filter(number -> winningNumbers.stream().noneMatch(lotto -> lotto.getLottoNumber() == number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("보너스 번호를 생성할 수 없습니다."));
        return new BonusLottoNumber(bonusNumber);
    }

    public int matchNumberCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void validate(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨번호는 null 또는 빈 값이 될 수 없습니다.");
        }
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호는 정확히 " + WINNING_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusLottoNumber;
    }
}
