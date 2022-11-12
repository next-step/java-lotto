package lotto.model;

import java.util.*;

public class LottoGenerator {
    public static final int LOTTO_MAX_LENGTH = 6;
    private static final int LOTTO_INIT_LENGTH = 0;

    public List<Lotto> addLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLotto()));
        }

        return lottos;
    }

    private Set<LottoNumber> createLotto() {
        List<LottoNumber> list = new ArrayList<>(LottoNumber.cache().values());
        Collections.shuffle(list);
        return new HashSet<>(list.subList(LOTTO_INIT_LENGTH, LOTTO_MAX_LENGTH));
    }
}
