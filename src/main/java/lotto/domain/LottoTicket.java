package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.exception.WrongLottoTicketException;

public class LottoTicket {

    public static final int PRICE = 1000;
    private static final int TICKET_NUMBER_SIZE = 6;
    private static final int UNIQUE_NUMBER_FREQUENCY = 1;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
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


    public static LottoTicket generateByLottoNumbers(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket generateByIntegerArray(int... integerArray) {
        List<LottoNumber> lottoNumbers = Arrays.stream(integerArray)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

    public int checkHowManyMatchedNumbers(LottoTicket anotherTicket) {
        List<LottoNumber> matchedNumbers = lottoNumbers.stream()
            .filter(anotherTicket.value()::contains)
            .collect(Collectors.toList());

        return matchedNumbers.size();
    }

    public boolean checkBonusNumberMatch(LottoNumber bonusBallNumber) {

        return lottoNumbers.contains(bonusBallNumber);
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
    }
}
