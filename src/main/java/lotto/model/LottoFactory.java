package lotto.model;

import java.util.*;

public class LottoFactory {
    public static final int LOTTO_MAX_LENGTH = 6;
    private static final int LOTTO_INIT_LENGTH = 0;

    public List<Lotto> addLotto(int auto, final List<Lotto> manualLotto) {
        List<Lotto> lottos = new ArrayList<>(manualLotto);

        for (int i = 0; i < auto; i++) {
            lottos.add(new Lotto(createAutoLotto()));
        }

        return lottos;
    }

    private Set<LottoNumber> createAutoLotto() {
        List<LottoNumber> list = new ArrayList<>(LottoNumber.cache().values());
        Collections.shuffle(list);
        return new HashSet<>(list.subList(LOTTO_INIT_LENGTH, LOTTO_MAX_LENGTH));
    }
}
