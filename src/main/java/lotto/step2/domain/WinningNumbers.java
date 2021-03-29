package lotto.step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final static int LOTTO_SIZE = 6;
    private final static String ILLEGAL_LOTTO_NUMBERS = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private final static String ILLEGAL_BONUS_NUMBER = "보너스 번호는 6개 로또 번호와 다른 숫자여야 합니다.";
    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] numbers, String bonusNumber) {
        this(new ArrayList<>(Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList())), new LottoNumber(bonusNumber));
    }

    public WinningNumbers(String[] numbers, int bonusNumber) {
        this(new ArrayList<>(Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList())), new LottoNumber(bonusNumber));
    }

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoSize();
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateLottoSize() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBERS);
        }
    }

    private void validateBonusNumber() {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_NUMBER);
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
