package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private static final int REQUIRED_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_SIZE) {
            throw new RuntimeException("로또 번호는 6개여야만 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    /**
     * @param otherLottoNumbers 비교할 다른 로또 번호
     * @return LottoNumbers 인스턴스 자신과 다른 LottoNumbers 객체를 비교하여, 값이 동일한 LottoNumber의 개수
     */
    public int getSameNumbersCount(LottoNumbers otherLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber ->
                        otherLottoNumbers.getLottoNumbers().contains(lottoNumber)).count();
    }
}