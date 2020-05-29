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
        validateLottoNumbers(lottoNumbers);

        return new LottoTicket(lottoNumbers);
    }

    private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != ALLOWED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수가 일치하지 않습니다");
        }
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .map(LottoNumber::get)
                .filter(winningNumbers::contains)
                .count());
    }
}
