package lotto.domain;

import java.util.Set;

public class LottoTicket {

    private static final int LOTTO_COUNT = 6;
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 넘버 갯수가 6개가 아닙니다.";
    public static final String NULL_INPUT_ERROR_MESSAGE = "로또 넘버가 NULL 또는 빈문자열 입니다.";
    private Set<LottoNumber> lottoTicketNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateBlank(lottoNumbers);
        validateCount(lottoNumbers);
        lottoTicketNumbers = lottoNumbers;
    }

    public int countMatchNumbers(LottoTicket otherLottoTicket) {
        return (int) this.lottoTicketNumbers.stream()
                .filter(lottoNumber -> otherLottoTicket.getLottoTicketNumbers().contains(lottoNumber))
                .count();
    }

    private void validateBlank(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers == null || lottoNumbers.isEmpty()){
            throw new NullPointerException(NULL_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public Set<LottoNumber> getLottoTicketNumbers() {
        return lottoTicketNumbers;
    }
}
