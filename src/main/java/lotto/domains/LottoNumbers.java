package lotto.domains;

import lotto.util.Convertor;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = makeLottoNumbers();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers(String stringLottoNumber) {
        this(Convertor.convertStringToList(stringLottoNumber));
    }

    private List<LottoNumber> makeLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>(LottoSubstituteNumbers.sixLottoNumbers());
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호는 중복될수 없습니다.");
        }
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또번호는 여섯자리를 입력해주세요");
        }
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int matchingNumberCount(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }
}
