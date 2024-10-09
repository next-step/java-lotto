package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottos {
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.generateLottoNumber());
        }
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
