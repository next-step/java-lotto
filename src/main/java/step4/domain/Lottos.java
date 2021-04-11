package step4.domain;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> userLottos, List<Lotto> autoLottos) {
        List<Lotto> lottos = Stream.of(userLottos, autoLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lottos of(List<String> userLottos) {
        List<Lotto> lottos = userLottos.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());
        
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
