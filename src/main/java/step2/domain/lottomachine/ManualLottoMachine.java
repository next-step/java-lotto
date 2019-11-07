package step2.domain.lottomachine;

import step2.domain.LottoNumber;
import step2.domain.LottoTicket;
import step2.exception.IllegalLottoNumberException;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static step2.domain.LottoNumber.MAX_NUMBER;
import static step2.domain.LottoNumber.MIN_NUMBER;

public class ManualLottoMachine extends LottoMachine {
    private static final int PADDING = -1;

    @Override
    public LottoTicket issueLottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);

        List<LottoNumber> manualLottoNumbers = numbers.parallelStream()
                .map(this::pickLottoNumber)
                .collect(toList());

        return new LottoTicket(manualLottoNumbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        numbers.parallelStream()
                .filter(this::isOutOfRange)
                .findAny()
                .ifPresent(this::throwLottoNumberException);
    }

    private boolean isOutOfRange(Integer number) {
        return (number < MIN_NUMBER) || (MAX_NUMBER < number);
    }

    private void throwLottoNumberException(Integer number) {
        throw new IllegalLottoNumberException(number);
    }

    private LottoNumber pickLottoNumber(Integer number) {
        return lottoNumbers.get(number + PADDING);
    }
}
