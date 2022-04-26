package me.devyonghee.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lottos {

    private static final String NULL_TICKETS_ERROR_MESSAGE = "tickets must not be null";
    private static final String NULL_WINNER_LOTTO_ERROR_MESSAGE = "lotto must not be null";
    private static final String NULL_WINNER_BONUS_NUMBER_ERROR_MESSAGE = "bonus number must not be null";

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        Objects.requireNonNull(lottos, NULL_TICKETS_ERROR_MESSAGE);
        this.lottos = lottos;
    }

    static Lottos from(List<Lotto> tickets) {
        return new Lottos(tickets);
    }

    int size() {
        return lottos.size();
    }

    public List<Lotto> list() {
        return Collections.unmodifiableList(lottos);
    }

    public Score score(Lotto target, LottoNumber bonusNumber) {
        Objects.requireNonNull(target, NULL_WINNER_LOTTO_ERROR_MESSAGE);
        Objects.requireNonNull(bonusNumber, NULL_WINNER_BONUS_NUMBER_ERROR_MESSAGE);
        return Score.from(lottos.stream()
                .map(lotto -> lotto.rank(target, bonusNumber))
                .collect(Collectors.toList()));
    }

    Lottos merge(Lottos lottos) {
        List<Lotto> newLottos = new ArrayList<>(this.lottos);
        newLottos.addAll(lottos.lottos);
        return from(newLottos);
    }

    public long autoCount() {
        return lottos.stream()
                .filter(Lotto::isAuto)
                .count();
    }

    public long manualCount() {
        return lottos.stream()
                .filter(Lotto::isManual)
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }
}
