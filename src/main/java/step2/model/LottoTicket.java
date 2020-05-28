package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create(List<LottoNumber> lottoNumbers) {
        if (!isValidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호 개수가 일치하지 않습니다");
        }

        return new LottoTicket(lottoNumbers);
    }

    private static boolean isValidLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers != null && lottoNumbers.size() == ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());
    }
}
