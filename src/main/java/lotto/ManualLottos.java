package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottos {

    private final List<Lotto> lottos;

    public ManualLottos(String... inputText) {
        this(transferInputTextAsLottos(inputText));
    }

    public ManualLottos(Set<Lotto> manualNumbers) {
        this(new ArrayList<>(manualNumbers));
    }

    private static Set<Lotto> transferInputTextAsLottos(String[] inputText) {
        return Arrays.stream(inputText)
                .map(s -> createLotto(s.split(",")))
                .collect(Collectors.toSet());
    }

    private static Lotto createLotto(String[] numberArray) {
        return new Lotto(Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet()));
    }

    public ManualLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> add(List<Lotto> autoLottos) {
        this.lottos.addAll(autoLottos);
        return this.lottos;
    }
}
