package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.LottoTicket;
import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.domain.factory.LottoNumbersFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoIssueStrategy implements LottoIssueStrategy {
    private static final int NUMBER_OF_DRAWS = 6;
    private static final int ZERO = 0;
    
    @Override
    public LottoTickets issueLottoTickets(PaymentPrice paymentPrice) {
        return new LottoTickets(issueLottoTicket(paymentPrice));
    }
    
    private List<LottoTicket> issueLottoTicket(PaymentPrice paymentPrice) {
        return IntStream.range(ZERO, paymentPrice.numberOfTickets())
                .mapToObj(ticketCount -> new LottoTicket(issueLotto(shuffleLottoNumbers())))
                .collect(Collectors.toList());
    }
    
    private List<LottoNumber> issueLotto(List<LottoNumber> shuffleLottoNumbers) {
        return IntStream.range(ZERO, NUMBER_OF_DRAWS)
                .mapToObj(shuffleLottoNumbers::get)
                .sorted()
                .collect(Collectors.toList());
    }
    
    private List<LottoNumber> shuffleLottoNumbers() {
        return shuffle(lottoNumbers());
    }
    
    private List<LottoNumber> shuffle(List<LottoNumber> randomLottoNumbers) {
        Collections.shuffle(randomLottoNumbers);
        return randomLottoNumbers;
    }
    
    private List<LottoNumber> lottoNumbers() {
        return LottoNumbersFactory.getInstance();
    }
}
