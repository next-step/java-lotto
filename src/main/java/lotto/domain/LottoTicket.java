package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumberLength(lottoNumbers);
        this.lottoNumbers = to(lottoNumbers);
    }

    private void validateLottoNumberLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d자리 입니다.", LOTTO_SIZE));
        }
    }

    private List<LottoNumber> to(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public int calculateSameNumberCount(LottoTicket lottoTicket) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoTicket::hasNumber)
                .count();
    }

    public boolean hasNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumber() {
        return lottoNumbers;
    }
}
