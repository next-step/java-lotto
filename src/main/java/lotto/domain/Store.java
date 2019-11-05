package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static final int THOUSAND = 1000;
    private final LottoMachine lottoMachine;

    public Store(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public IssuedLottos issueLottos(final int amount, final List<String> directLottoNumbers) {
        int directLottoCount = directLottoNumbers.size();
        final int count = (amount / THOUSAND) - directLottoCount;

        final List<Lotto> issuedLottos = new ArrayList<>();
        issuedLottos.addAll(issueDirectLottos(directLottoNumbers));
        issuedLottos.addAll(issueAutoLottos(count));

        return new IssuedLottos(issuedLottos);
    }

    private List<Lotto> issueAutoLottos(final int count) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            final Lotto issuedLotto = lottoMachine.issue();
            lottos.add(issuedLotto);
        }

        return lottos;
    }

    private List<Lotto> issueDirectLottos(final List<String> directLottoNumbers) {
        final List<Lotto> lottos = new ArrayList<>();

        for (String directLottoNumber : directLottoNumbers) {
            final Lotto isseudDirectLotto = lottoMachine.issue(directLottoNumber);
            lottos.add(isseudDirectLotto);
        }

        return lottos;
    }
}
