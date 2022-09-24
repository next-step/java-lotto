package lotto.step2.domain.strategy.issuelottostrategy;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.strategy.dto.PaymentInformationDTO;
import lotto.step2.domain.strategy.factory.LottoNumbersFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoIssueLottoStrategy implements IssueLottoStrategy {
    
    private final PaymentInformationDTO paymentInformationDTO;
    
    public AutoIssueLottoStrategy(PaymentInformationDTO paymentInformationDTO) {
        this.paymentInformationDTO = paymentInformationDTO;
    }
    
    @Override
    public List<List<LottoNumber>> issueLottoList() {
        return IntStream.range(0, paymentInformationDTO.getNumberOfTicketsPurchased())
                .mapToObj(ticketCount -> issueLotto(shuffleLottoNumbers()))
                .collect(Collectors.toList());
    }
    
    private List<LottoNumber> issueLotto(List<LottoNumber> shuffle) {
        return IntStream.rangeClosed(0, 6)
                .mapToObj(shuffle::get)
                .collect(Collectors.toList());
    }
    
    private List<LottoNumber> shuffleLottoNumbers() {
        List<LottoNumber> randomLottoNumbers = new ArrayList<>(createLottoNumbers());
        return shuffle(randomLottoNumbers);
    }
    
    private List<LottoNumber> shuffle(List<LottoNumber> randomLottoNumbers) {
        Collections.shuffle(randomLottoNumbers);
        return randomLottoNumbers;
    }
    
    private List<LottoNumber> createLottoNumbers() {
        return LottoNumbersFactory.create();
    }
}
