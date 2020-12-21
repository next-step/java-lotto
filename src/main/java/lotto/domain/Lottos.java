package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    static final int MIN_LOTTO_SIZE = 1;

    private final List<Lotto> lottos;

    public Lottos(int automatedLottoSize, List<Lotto> manualLottos) {
        validate(automatedLottoSize, manualLottos);
        this.lottos = Collections.unmodifiableList(initiateLottos(automatedLottoSize, manualLottos));
    }

    private void validate(int automatedLottoSize, List<Lotto> manualLottos) {
        validateLottos(manualLottos);
        validateLottoSize(automatedLottoSize, manualLottos.size());
    }

    private void validateLottoSize(int automatedLottoSize, int manualLottoSize) {
        int totalLottoSize = automatedLottoSize + manualLottoSize;
        if (totalLottoSize < MIN_LOTTO_SIZE) {
            throw new IllegalArgumentException("1개 이상의 로또를 생성해야합니다.");
        }
        if (manualLottoSize > totalLottoSize) {
            throw new IllegalArgumentException("수동으로 입력된 로또의 갯수는 총 구매 로또의 갯수보다 작거나 같아야합니다.");
        }
    }

    private void validateLottos(List<Lotto> manualLottos) {
        if (manualLottos == null) {
            throw new IllegalArgumentException("잘못된 수동 로또가 전달되었습니다.");
        }
    }

    private List<Lotto> initiateLottos(int automatedLottoSize, List<Lotto> manualLottos) {
        List<Lotto> lottos = initiateAutomatedLottos(automatedLottoSize);
        lottos.addAll(manualLottos);
        return lottos;
    }

    private List<Lotto> initiateAutomatedLottos(int automatedLottoSize) {
        List<Lotto> lottos = new ArrayList<>(automatedLottoSize);
        for (int i = 0; i < automatedLottoSize; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public LottoResult retrieveStatistics(WinningLotto winningLotto) {
        return new LottoResult(findLottoRanks(winningLotto));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<LottoRank> findLottoRanks(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }
}
