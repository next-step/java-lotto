package lotto.domain;

import java.util.List;
import java.util.Optional;

import static lotto.domain.LottoShop.THOUSAND;

public class ExceptionHandler {

    public static void validLottoSize(List<Integer> lottoNumber) {
        if (lottoNumber.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 여섯개를 입력해야 합니다.");
        }
    }

    public static void validLottoNumberRange(List<Integer> lottoNumber) {
        Optional<Integer> overNumber = lottoNumber.stream()
                .filter(number -> number > Lotto.MAX_LOTTO_NUMBER || number < Lotto.MIN_LOTTO_NUMBER)
                .findAny();

        if (overNumber.isPresent()) {
            throw new IllegalArgumentException("로또 번호는 1이상 45 이하여야 합니다");
        }
    }

    public static void validPrice(int payment) {
        if (payment < THOUSAND) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 1000원 입니다");
        }
    }

    public static void validDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        boolean isDuplicate = lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();
        if (isDuplicate) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validDuplicatedBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        System.out.println("winningLotto = " + winningLotto);
        boolean isDuplicate = winningLotto.lotto.stream().anyMatch(number -> number.equals(bonusNumber));
        if (isDuplicate) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
