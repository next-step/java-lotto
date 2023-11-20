package src.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos of(List<Lotto> values) {
        return new Lottos(values);
    }

    public MatchStatus match(WinningLotto winningLotto) {
        Map<Place, Integer> matchStatus = new EnumMap<>(Place.class);
        for (Lotto lotto : values) {
            Place place = winningLotto.match(lotto);
            matchStatus.put(place, matchStatus.getOrDefault(place, 0) + 1);
        }

        return MatchStatus.of(matchStatus);
    }

    public int size() {
        return values.size();
    }

    public List<Lotto> values() {
        return new ArrayList<>(values);
    }

    public Lottos addLottos(Lottos lottos) {
        List<Lotto> cloneLottos = values();
        cloneLottos.addAll(lottos.values());

        return new Lottos(cloneLottos);
    }
}
