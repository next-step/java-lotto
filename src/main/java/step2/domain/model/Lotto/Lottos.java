package step2.domain.model.Lotto;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createLotto()); //
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        String lottoString = lottos.stream()
                .map(lotto -> String.valueOf(lotto.toString()))
                .collect(Collectors.joining("\n"));

        return String.format("%s", lottoString);
    }
}
