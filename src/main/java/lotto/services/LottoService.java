package lotto.services;

import lotto.models.IssuedLotto;
import lotto.models.enums.IssueType;
import lotto.models.request.IssueLottoRequest;
import lotto.strategy.PickNumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public List<IssuedLotto> issueLottos(IssueLottoRequest issueLottoRequest, PickNumberStrategy strategy) {
        int count = issueLottoRequest.getPayment() / IssuedLotto.PRICE;

        List<IssuedLotto> lottos = issueLottoRequest.getManualLottoNumbers()
                .stream()
                .map(manualLottoNumber -> IssuedLotto.of(manualLottoNumber, IssueType.manual))
                .collect(Collectors.toList());
        while (lottos.size() < count) {
            lottos.add(IssuedLotto.of(strategy.getNumbers(), IssueType.random));
        }

        return lottos;
    }

}
