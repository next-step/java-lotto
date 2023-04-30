package lotto.domain;

import java.util.List;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket(NumberCreationStrategy strategy) {
        this(strategy.createNumber());
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumberLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리입니다.");
        }
    }

    public int calculateSameNumberCount(LottoTicket lottoTicket) {
        List<Integer> lottoNumber = lottoTicket.getLottoNumber();
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber::contains)
                .count();
    }

    public boolean hasBonusNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers;
    }
}
