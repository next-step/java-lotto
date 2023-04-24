package lotto.domain;

import java.util.List;

public class LottoNumber {

    private final List<Integer> lottoNumber;

    public LottoNumber(NumberCreationStrategy strategy) {
        this.lottoNumber = createLottoNumber(strategy);
    }

    private List<Integer> createLottoNumber(NumberCreationStrategy strategy) {
        return strategy.createNumber();
    }

    public LottoNumber(List<Integer> lottoNumber) {
        validateLottoNumberLength(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberLength(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리입니다.");
        }
    }

    public int calculateSameNumberCount(LottoNumber number) {
        List<Integer> lottoNumber = number.getLottoNumber();
        return (int) this.lottoNumber.stream()
                .filter(lottoNumber::contains)
                .count();
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
