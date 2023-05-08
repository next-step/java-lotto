package lotto.step4.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoCount {
    // 원시값을 포장
    private final int lottoCount;
    private final int manualLottoCount;
    private final List<Lotto> lottoFromManual;

    private static final int DIVISOR = 1_000;

    public LottoCount(int price, int manualLottoCount, List<Set<Integer>> lottoFromManual) {
        if (!validatePrice(price)) {
            throw new IllegalArgumentException(price + "원으로는 로또를 구매할 수 없습니다.(" + DIVISOR + "원 단위로 입력해주세요.)");
        }
        if (!validateManualLottoCount(manualLottoCount)) {
            throw new IllegalArgumentException("수동 입력은 0이상의 정수만 가능합니다.(입력값: " + manualLottoCount + ")");
        }
        this.lottoCount = (price / DIVISOR) - manualLottoCount;
        this.manualLottoCount = manualLottoCount;
        this.lottoFromManual = toManualLotto(lottoFromManual);
    }

    public List<Lotto> play(LottoStrategy lottoStrategy) {
        List<Lotto> lottoFromAuto = IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoStrategy.createLotto())
                .collect(Collectors.toList());

        return Stream.concat(lottoFromManual.stream(), lottoFromAuto.stream())
                .collect(Collectors.toList());
    }

    private List<Lotto> toManualLotto(List<Set<Integer>> lottoFromManual) {
        if (!validateManualNumber(lottoFromManual)) {
            throw new IllegalArgumentException("수동 입력 개수와 수동 로또 번호 입력 개수는 같아야합니다.(수동 입력 개수: " + manualLottoCount + " != 수동 로또 번호 입력 개수: " + lottoFromManual.size() + ")");
        }
        return lottoFromManual.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private boolean validateManualNumber(List<Set<Integer>> lottoFromManual) {
        if (manualLottoCount != lottoFromManual.size()) {
            return false;
        }
        return true;
    }

    private boolean validatePrice(int price) {
        int lottoCount = (price / DIVISOR);
        int thousandUnit = price % DIVISOR;
        if (lottoCount < 0 || thousandUnit != 0) {
            return false;
        }
        return true;
    }

    private boolean validateManualLottoCount(int manualLottoCount) {
        if (manualLottoCount < 0) {
            return false;
        }
        return true;
    }


    public int getLottoCount() {
        return lottoCount;
    }

    public int getPrice() {
        return (lottoCount + manualLottoCount) * DIVISOR;
    }
}
