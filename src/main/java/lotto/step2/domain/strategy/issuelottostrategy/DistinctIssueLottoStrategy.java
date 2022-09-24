package lotto.step2.domain.strategy.issuelottostrategy;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.strategy.factory.LottoNumbersFactory;
import lotto.step2.domain.PaymentInformationDTO;
import lotto.step2.domain.strategy.shufflestrategy.ShuffleStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctIssueLottoStrategy implements IssueLottoStrategy {
    
    private final PaymentInformationDTO paymentInformationDTO;
    
    public DistinctIssueLottoStrategy(PaymentInformationDTO paymentInformationDTO) {
        this.paymentInformationDTO = paymentInformationDTO;
    }
    
    @Override
    public List<List<LottoNumber>> issueLottoList() {
        return IntStream.iterate(0, count -> count + 1)
                .mapToObj(count -> issueLotto(shuffleLottoNumbers(paymentInformationDTO.getShuffleStrategy())))
                .distinct()
                .limit(paymentInformationDTO.getNumberOfTicketsPurchased())
                .collect(Collectors.toList());
    }
    
    private static List<LottoNumber> issueLotto(List<LottoNumber> shuffle) {
        return IntStream.rangeClosed(0, 6)
                .mapToObj(shuffle::get)
                .collect(Collectors.toList());
    }
    
    private static List<LottoNumber> shuffleLottoNumbers(ShuffleStrategy shuffleStrategy) {
        return shuffleStrategy.shuffle(createLottoNumbers());
    }
    
    private static List<LottoNumber> createLottoNumbers() {
        return LottoNumbersFactory.create();
    }
}
