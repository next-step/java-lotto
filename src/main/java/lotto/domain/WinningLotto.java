package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;


    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonus) {
        LottoNumbers winningNumbers = LottoNumbers.of(numbers);
        LottoNumber bonusNumber = LottoNumber.valueOf(bonus);

        validateDuplicated(winningNumbers, bonusNumber);

        return new WinningLotto(winningNumbers, bonusNumber);
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

    public LottoResult drawing(List<LottoNumbers> tickets) {
        List<Prize> prizes = tickets.stream()
                .map(ticket -> ticket.matchNumbers(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
        return new LottoResult(prizes);
    }
}
