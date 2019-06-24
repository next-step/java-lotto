package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    static final String ALERT_NUMBER_OVERLAP = "중복된 로또 번호가 존재합니다.";
    static final String AlERT_DIFFERENT_SIZE_OF_NUMBERS = "로또번호의 개수가 6개가 아닙니다.";

    private final List<LottoNumber> lottoTicket;

    LottoTicket(List<LottoNumber> lottoTicket) {
        validationNumberSize(lottoTicket);
        validationNumberOverlap(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validationNumberSize(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LottoTicketGenerator.BASIC_LOTTO_SIZE) {
            throw new IllegalArgumentException(AlERT_DIFFERENT_SIZE_OF_NUMBERS);
        }
    }

    private void validationNumberOverlap(List<LottoNumber> lottoTicket) {
        long SizeOfLottoTicket = lottoTicket.stream()
                .mapToInt(LottoNumber::getNumber)
                .distinct()
                .count();

        if (SizeOfLottoTicket != LottoTicketGenerator.BASIC_LOTTO_SIZE) {
            throw new IllegalArgumentException(ALERT_NUMBER_OVERLAP);
        }
    }

    public long getNumberOfMatchedLuckyNumber(LuckyNumber luckyNumber) {
        List<Integer> luckNumberLastWeek =
                luckyNumber.getLuckyNumber()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .collect(Collectors.toList());
        return lottoTicket.stream()
                .map(LottoNumber::getNumber)
                .filter(i -> luckNumberLastWeek.contains(i))
                .count();

        //TODO: Q. 이 부분을 어떻게 구현하면 좋을지 궁금합니다..
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
