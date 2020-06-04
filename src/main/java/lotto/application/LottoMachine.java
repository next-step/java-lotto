package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.infra.domain.AutoLottoNumberSelectRule;
import lotto.infra.domain.ManualLottoNumberSelectRule;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    public LottoIssueResponse issue(LottoIssueRequest request) {
        Lottos autoLottos = issueAutoLottos(request.getAutoQuantity());
        Lottos manualLottos = issueManualLottos(request.getManualNumbersList());
        return new LottoIssueResponse(autoLottos, manualLottos);
    }

    private Lottos issueAutoLottos(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(new AutoLottoNumberSelectRule()))
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    private Lottos issueManualLottos(List<LottoNumbers> manualNumbersList) {
        return manualNumbersList.stream()
                .map(m -> new Lotto(new ManualLottoNumberSelectRule(m)))
                .collect(collectingAndThen(toList(), Lottos::new));
    }
}
