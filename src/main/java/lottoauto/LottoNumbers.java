package lottoauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class LottoNumbers {
    private  static final String SPLIT_REGEX = ",";

    protected static final int ZERO = 0;
    protected static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String winningNumbersContents) {
        this.lottoNumbers = new ArrayList<>();
        for (String str: winningNumbersContents.split(SPLIT_REGEX)) {
            Integer num = Integer.parseInt(str.trim());

            lottoNumbers.add(new LottoNumber(num));
        }

        validateDuplicate(lottoNumbers);
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복은 존재할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers, (a, b)-> a.lottoNumber() - b.lottoNumber() > 0 ? 1 : a.lottoNumber() - b.lottoNumber() < 0 ? -1 : 0  );

        return lottoNumbers.toString();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public boolean checkHitBonus(WinningNumbersWithBonus winningNumbersWithBonus) {
        for (LottoNumber lottoNumber: lottoNumbers) {
            if (winningNumbersWithBonus.isHitBonusNumber(lottoNumber)) {
                return true;
            }
        }

        return false;
    }

    public HitCount checkHitCount(WinningNumbersWithBonus winningNumbersWithBonus) {
        int result = 0;

        for (LottoNumber lottoNumber: lottoNumbers) {
            result += winningNumbersWithBonus.contains(lottoNumber) ? 1 : 0;
        }

        return new HitCount(result);
    }
}
