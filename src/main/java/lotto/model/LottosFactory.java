package lotto.model;

import java.util.*;

public class LottosFactory {
    public static final int LOTTO_MAX_LENGTH = 6;
    private static final int LOTTO_INIT_LENGTH = 0;
    private final List<LottoFactory> manualLotto;

    public LottosFactory(List<LottoFactory> manualLotto) {
        this.manualLotto = manualLotto;
    }

    public Lottos allLottos(int auto) {
        List<Lotto> lottoList = new ArrayList<>();

        for (LottoFactory lottoFactory : manualLotto) {
            lottoList.add(lottoFactory.stringToLotto());
        }

        for (int i = 0; i < auto; i++) {
            lottoList.add(new Lotto(createAuto()));
        }

        return new Lottos(lottoList);
    }

    private Set<LottoNumber> createAuto() {
        List<LottoNumber> list = new ArrayList<>(LottoNumber.cache().values());
        Collections.shuffle(list);
        return new HashSet<>(list.subList(LOTTO_INIT_LENGTH, LOTTO_MAX_LENGTH));
    }
}
