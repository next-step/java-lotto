package lotto.services;

import lotto.models.Lotto;
import lotto.models.request.LottoNumberRequest;
import lotto.models.request.PaymentRequest;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLotto(PaymentRequest paymentRequest, List<LottoNumberRequest> lottoNumberRequests, PickNumberStrategy strategy) {
        int count = paymentRequest.getPayment() / LOTTO_PRICE;

        List<Lotto> lottos = lottoNumberRequests
                .stream()
                .map(req -> Lotto.of(req.getNumber()))
                .collect(Collectors.toList());
        while (lottos.size() < count) {
            lottos.add(Lotto.of(strategy.getNumbers()));
        }

        return lottos;
    }

}
