package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.LottoTicket;
import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentInformation;
import lotto.step2.domain.factory.LottoNumbersFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoIssueStrategy implements LottoIssueStrategy {
    private static final int NUMBER_OF_DRAWS = 6;
    private static final int ZERO = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    
    @Override
    public LottoTickets issueLottoTickets(PaymentInformation paymentInformation) {
        return new LottoTickets(issueLottoTicket(paymentInformation));
    }
    
    private List<LottoTicket> issueLottoTicket(PaymentInformation paymentInformation) {
        return IntStream.range(ZERO, paymentInformation.countOfAutoLotto())
                .mapToObj(ticketCount -> new LottoTicket(issueLotto(getShuffledLottoNumber())))
                .collect(Collectors.toList());
    }
    
    private List<Integer> getShuffledLottoNumber() {
        return shuffle(getInitLottoNumber());
    }
    
    private List<Integer> getInitLottoNumber() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
    
    private List<Integer> shuffle(List<Integer> randomLottoNumbers) {
        Collections.shuffle(randomLottoNumbers);
        return randomLottoNumbers;
    }
    
    private List<LottoNumber> issueLotto(List<Integer> shuffleLottoNumbers) {
        return IntStream.range(ZERO, NUMBER_OF_DRAWS)
                .mapToObj(shuffleLottoNumbers::get)
                .map(LottoNumbersFactory::getLottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }
}
