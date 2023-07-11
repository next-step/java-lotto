package lottogame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottogame.domain.LottoNumbers;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.reponse.LottoPurchaseResponse;
import lottogame.service.reponse.LottoPurchaseResponse.LottoNumbersResponse;

public class LottoService {

    private static final int PURCHASABLE_UNIT = 1000;
    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoPurchaseResponse purchase(int money) {
        assertMoney(money);
        return toLottoPurchaseResponse(createLottoNumbers(money));
    }

    private List<LottoNumbers> createLottoNumbers(int money) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int count = 0; count < money % PURCHASABLE_UNIT; count++) {
            lottoNumbersList.add(new LottoNumbers(numberGenerator));
        }
        return lottoNumbersList;
    }

    private void assertMoney(int money) {
        if (money % PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", PURCHASABLE_UNIT, money));
        }
    }

    private LottoPurchaseResponse toLottoPurchaseResponse(List<LottoNumbers> lottoNumbersList) {
        return new LottoPurchaseResponse(
            lottoNumbersList.stream()
                .map(lottoNumbers -> new LottoNumbersResponse(lottoNumbers.getValues()))
                .collect(Collectors.toList())
        );
    }
}
