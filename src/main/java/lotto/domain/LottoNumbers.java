package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER + "개의 로또 번호를 입력해 주세요.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int contains(LottoNumbers lottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(lottoTicket::contains)
                .mapToInt(lotteryNumber -> 1)
                .count();
    }
}
