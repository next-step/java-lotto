package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(LottoNumber.of(i));
        }
    }

    public static Lottos createLottos(List<Lotto> manualLottos, int autoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(createAutoLottos(autoQuantity));
        return new Lottos(lottos);
    }

    public static List<Lotto> createAutoLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    private static Lotto createAutoLotto() {
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.sort();
        return lotto;
    }
}
