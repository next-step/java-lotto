package lotto.domains;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = makeLottoNumbers();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateNumber(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList = new ArrayList<>(LottoSubstituteNumbers.sixLottoNumbers());
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private void validateNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("로또번호는 1부터 45까지의 값을 입력해주세요");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호는 중복될수 없습니다.");
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또번호는 여섯자리를 입력해주세요");
        }
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int matchingNumberCount(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }
}
