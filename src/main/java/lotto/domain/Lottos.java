package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 최종 로또(수동, 자동) 컬렉션
 */
public class Lottos {
    public static final String MIN_SIZE_LOTTOS_ERROR_MESSAGE = "최종 로또는 최소 한개 이상 가져야 합니다.";
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> manualLottos, final List<Lotto> autoLottos) {
        validateLottos(manualLottos, autoLottos);
        this.lottos = concatLottos(manualLottos, autoLottos);
    }

    private void validateLottos(final List<Lotto> manualLottos, final List<Lotto> autoLottos) {
        if (manualLottos.isEmpty() &&
                autoLottos.isEmpty()) {
            throw new IllegalArgumentException(MIN_SIZE_LOTTOS_ERROR_MESSAGE);
        }
    }

    private List<Lotto> concatLottos(final List<Lotto> manualLottos, final List<Lotto> autoLottos) {
        return Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
