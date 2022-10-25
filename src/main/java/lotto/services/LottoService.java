package lotto.services;

import lotto.models.IssuedLotto;
import lotto.models.Lotto;
import lotto.models.request.LottoNumberRequest;
import lotto.models.request.PaymentRequest;
import lotto.strategy.PickNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<IssuedLotto> issueManualLotto(List<LottoNumberRequest> lottoNumberRequests) {
        return lottoNumberRequests
                .stream()
                .map(IssuedLotto::from)
                .collect(Collectors.toList());
    }

    public List<IssuedLotto> issueRandomLotto(PaymentRequest paymentRequest, PickNumberStrategy strategy) {
        int count = paymentRequest.getPayment() / IssuedLotto.PRICE;

        List<IssuedLotto> lottos = new ArrayList<>();
        while (lottos.size() < count) {
            lottos.add(IssuedLotto.of(strategy.getNumbers()));
        }

        return lottos;
    }

}
