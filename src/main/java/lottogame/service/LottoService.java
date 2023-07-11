package lottogame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottogame.domain.LottoNumbers;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.reponse.LottoPurchaseResponse;
import lottogame.service.reponse.LottoPurchaseResponse.LottoNumbersResponse;

public class LottoService {

    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoPurchaseResponse buy(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(String.format("money는 1000원으로 나누어 떨어져야 합니다 money: \"%d\"", money));
        }

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        int count = money % 1000;
        for (int i = 0; i < count; i++) {
            lottoNumbersList.add(new LottoNumbers(numberGenerator));
        }
        return toLottoPurchaseResponse(lottoNumbersList);
    }

    private LottoPurchaseResponse toLottoPurchaseResponse(List<LottoNumbers> lottoNumbersList) {
        return new LottoPurchaseResponse(
            lottoNumbersList.stream()
                .map(lottoNumbers -> new LottoNumbersResponse(lottoNumbers.getValues()))
                .collect(Collectors.toList())
        );
    }

}
