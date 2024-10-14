package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private static final String IS_DUPLICATE_NUMBER = "중복된 번호가 있습니다.";
    private static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = makeLotto(lottoNumbers);
    }

    public Lotto(String[] inputNumbers) {
        List<Integer> lottoNumbers = splitInput(inputNumbers);
        validateLotto(lottoNumbers);
        this.lottoNumbers = makeLotto(lottoNumbers);
    }

    private List<LottoNumber> makeLotto(List<Integer> lottoNumbers) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int number : makeSortLotto(lottoNumbers)) {
            lottoNumberList.add(new LottoNumber(number));
        }
        return lottoNumberList;
    }

    private List<Integer> splitInput(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(convertStringToInt(number));
        }
        return numbers;
    }

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        valdiateDuplicate(lottoNumbers);
    }

    private void validateLottoSetSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private List<Integer> makeSortLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.getLottoNumber());
        }
        return Collections.unmodifiableList(numbers);
    }

    public LottoRank getLottoResult(WinningLotto winningLotto) {
        int equalCount = getMatchCount(winningLotto.getWinningLotto());
        return getRank(equalCount, winningLotto.getBonusNumber());
    }

    private int getMatchCount(List<Integer> winningLottoNumbers) {
        return (int) winningLottoNumbers.stream()
                .filter(num -> isNumberContain(num))
                .count();
    }

    public boolean isNumberContain(int number) {
        return lottoNumbers.contains(new LottoNumber(number));
    }

    private LottoRank getRank(int equalCount, int bonusNumber) {
        LottoRank lottoRank = LottoRank.matchRank(equalCount);
        if (lottoRank.equals(SECOND)) {
            return isSecondRank(bonusNumber);
        }
        return lottoRank;
    }

    private LottoRank isSecondRank(int bonusNumber) {
        if (isNumberContain(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    public void validateDuplicate(int number) {
        if (isNumberContain(number)) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
