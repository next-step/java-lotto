package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.exception.WrongLottoTicketException;

public class LottoTicket {

    private static final int TICKET_NUMBER_SIZE = 6;
    private static final int UNIQUE_NUMBER_FREQUENCY = 1;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoTicket(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoTicket(List<LottoNumber> lottoNumbers) {
        checkNumberSize(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private void checkDuplicateNumber(List<LottoNumber> lottoNumbers) {

        Optional<LottoNumber> duplicateNumber = lottoNumbers.stream()
            .filter(e -> isNotUniqueLottoNumber(lottoNumbers, e))
            .findFirst();

        if (duplicateNumber.isPresent()) {
            throw new WrongLottoTicketException(
                String.format("로또티켓에는 중복된 숫자는 사용할수 없습니다. 중복숫자: %s", duplicateNumber.get()));
        }
    }

    private boolean isNotUniqueLottoNumber(List<LottoNumber> lottoNumbers, LottoNumber number) {
        return UNIQUE_NUMBER_FREQUENCY != Collections.frequency(lottoNumbers, number);
    }

    private void checkNumberSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != TICKET_NUMBER_SIZE) {
            throw new WrongLottoTicketException("로또티켓은 6개의 숫자를 가져야만 합니다.");
        }
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
    }


    public static LottoTicket generateByIntegerList(List<Integer> integerNumbers) {
        List<LottoNumber> lottoNumbers = integerNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
