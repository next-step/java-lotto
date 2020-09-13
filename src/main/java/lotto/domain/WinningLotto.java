package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class WinningLotto {

    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDuplicated(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public static WinningLotto of(List<Integer> numbers, int bonus) {
        return of(LottoNumbers.of(numbers), LottoNumber.valueOf(bonus));
    }

    // 테스트 코드에서 사용
    // 첫 정수가 보너스 번호라고 가정한다.
    public static WinningLotto of(int bonus, Integer... numbers) {
        return of(Arrays.asList(numbers), bonus);
    }

    private static void validateDuplicated(LottoNumbers numbers, LottoNumber bonusNumber) {
        if (numbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 6개의 숫자중 하나와 중복됩니다.");
        }
    }

    public Prize matching(LottoNumbers ticket) {
        return ticket.matchNumbers(winningNumbers, bonusNumber);
    }
}
