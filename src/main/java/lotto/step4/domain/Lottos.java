package lotto.step4.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(LottoStrategy lottoStrategy, LottoCount lottCount, ManualLotto manualLotto) {
        this.lottos = getAllLottos(lottoStrategy, lottCount, manualLotto);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> getAllLottos(LottoStrategy lottoStrategy, LottoCount lottCount, ManualLotto manualLotto) {
        List<Lotto> autoLottos = createAutoLottos(lottoStrategy, lottCount, manualLotto.getManualLottoCount());
        List<Lotto> manualLottos = createManualLottos(manualLotto);

        return Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }

    private List<Lotto> createManualLottos(ManualLotto manualLotto) {
        int manualLottoCount = manualLotto.getManualLottoCount();
        List<Set<Integer>> lottoFromManual = manualLotto.getLottoFromManual();

        if (!isValidateLottoCount(manualLottoCount)) {
            throw new IllegalArgumentException("수동 입력은 0이상의 정수만 가능합니다.(입력값: " + manualLottoCount + ")");
        }
        if (!isValidateManualNumber(lottoFromManual, manualLottoCount)) {
            throw new IllegalArgumentException("수동 입력 개수와 수동 로또 번호 입력 개수는 같아야합니다.(수동 입력 개수: " + manualLottoCount + " != 수동 로또 번호 입력 개수: " + lottoFromManual.size() + ")");
        }
        return lottoFromManual.stream()
                .map(l -> new Lotto(new TreeSet<>(l)))
                .collect(Collectors.toList());
    }

    private List<Lotto> createAutoLottos(LottoStrategy lottoStrategy, LottoCount lottCount, int manualLottoCount) {
        return lottCount.play(lottoStrategy, manualLottoCount);
    }

    private boolean isValidateLottoCount(int lottoCount) {
        if (lottoCount < 0) {
            return false;
        }
        return true;
    }

    private boolean isValidateManualNumber(List<Set<Integer>> lottoFromManual, int manualLottoCount) {
        if (manualLottoCount != lottoFromManual.size()) {
            return false;
        }
        return true;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
