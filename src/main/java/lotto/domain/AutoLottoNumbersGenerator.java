package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoTicket.MINIMUM_PRICE;


public class AutoLottoNumbersGenerator {

    public static final String TICKET_PRICE_ERROR_MESSAGE = "티켓값은 최소 1000원 이상이어야 합니다.";

    private final NumbersGenerator lottoNumbersGenerator;

    public AutoLottoNumbersGenerator(NumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<LottoNumbers> generate(int price) {
        validatePrice(price);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < price / MINIMUM_PRICE; i++) {
            lottoNumbersList.add(LottoNumbers.of(lottoNumbersGenerator.generate()));
        }
        return lottoNumbersList;
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(TICKET_PRICE_ERROR_MESSAGE);
        }
    }
}
