package lottoAuto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<Lotto> lottos = new ArrayList<>();

    public LottoGenerator(int amount) {
        for (int i = 0; i < amount; i++) {
            lottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        Collections.shuffle(LottoNumbers.lottoNumbers);
        Set<LottoNumber> lotto = LottoNumbers.lottoNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(lottoNumber -> new LottoNumber(lottoNumber))
                .collect(Collectors.toSet());

        return new Lotto(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
