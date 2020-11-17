package study.lotto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private final List<LottoNumber> winLottoNumbers;

    public WinLottoNumbers(List<LottoNumber> winLottoNumbers) {
        this.winLottoNumbers = winLottoNumbers;

        throwIfNumbersNull();
        throwIfNumberCountNotMatch();
    }

    private void throwIfNumberCountNotMatch() {
        if (winLottoNumbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해주세요.");
        }
    }

    private void throwIfNumbersNull() {
        if (Objects.isNull(winLottoNumbers)) {
            throw new IllegalArgumentException("당첨 번호를 입력해주세요.");
        }
    }

    public List<LottoNumber> match(Lotto lotto) {
        List<LottoNumber> matchingLottoNumbers = new ArrayList<>();
        // 일치하는 번호 추가
        this.winLottoNumbers.stream()
                .filter(lotto::contains)
                .forEach(matchingLottoNumbers::add);

        return matchingLottoNumbers;
    }

}
