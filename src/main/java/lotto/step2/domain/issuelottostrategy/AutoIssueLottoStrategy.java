package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.domain.factory.LottoNumbersFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoIssueLottoStrategy implements IssueLottoStrategy {
    
    private final PaymentPrice paymentPrice;
    
    public AutoIssueLottoStrategy(PaymentPrice paymentPrice) {
        this.paymentPrice = paymentPrice;
    }
    
    @Override
    public List<List<LottoNumber>> issueLottoList() {
        return IntStream.range(0, paymentPrice.numberOfTickets())
                .mapToObj(ticketCount -> issueLotto(shuffleLottoNumbers()))
                .collect(Collectors.toList());
    }
    
    private List<LottoNumber> issueLotto(List<LottoNumber> shuffleLottoNumbers) {
        return IntStream.range(0, 7)
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
