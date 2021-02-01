package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerLotto implements Lotto {

    private final LottoNumber BonusBall;
    private final List<LottoNumber> numbers;


    public WinnerLotto(LottoNumber bonusBall, List<LottoNumber> numbers) {
        checkSizeOfLotto(numbers);
        checkDuplicatedNumber(numbers);
        checkLottoContainsBonusball(bonusBall,numbers);
        BonusBall = bonusBall;
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return BonusBall;
    }

    private void checkLottoContainsBonusball (LottoNumber bonusBall, List<LottoNumber> numbers) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스번호가 로또번호와 중복됩니다.");
        }
    }

    private void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if (lottoNumbersChecker.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }

    }

    public static List<LottoNumber> getWinnerLottoWithSplitting(String text) {
        String [] inputs = text.split(DELIMITER);
        List<LottoNumber> winnerLotto = new ArrayList<>();
        for (String input : inputs) {
            winnerLotto.add(new LottoNumber(Validator.checkIsIntegerAndIsNegative(input)));
        }
        checkSizeOfLotto(winnerLotto.size());
        return winnerLotto;
    }

    private static void checkSizeOfLotto(int size) {
        if (size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
    }
}
