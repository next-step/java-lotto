package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    static final int MIN_LOTTO_SIZE = 1;

    private final List<Lotto> lottos;

    public Lottos(int size) {
        validate(size);
        this.lottos = initiateLottos(size);
    }

    private void validate(int size) {
        if (size < MIN_LOTTO_SIZE) {
            throw new IllegalArgumentException("1개 이상의 로또를 생성해야합니다.");
        }
    }

    private List<Lotto> initiateLottos(int size) {
        List<Lotto> lottos = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public LottoResult retrieveStatistics(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new LottoResult(findLottoResultType(winningLotto, bonusLottoNumber));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<LottoResultType> findLottoResultType(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return lottos.stream()
                .map(lotto -> lotto.findLottoResultType(winningLotto, bonusLottoNumber))
                .collect(Collectors.toList());
    }
}
