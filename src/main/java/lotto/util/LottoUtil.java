package lotto.util;

import lotto.domain.InputMoney;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {
    public static List<Lotto> createAutoLottoList(InputMoney money) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoGenerator generator = new RandomLottoGenerator();
        for (int i = 0; i < money.getAvailableLottoSize(); i++) {
            lottoList.add(new Lotto(generator));
        }
        return lottoList;
    }

    public static Lotto createMenualLotto(List<Integer> numbers) {
        LottoGenerator generator = new ManualLottoGenerator(numbers);
        Lotto lotto = new Lotto(generator);
        return lotto;
    }

    public static List<Lotto> createMenualLottoList(List<Integer> numbers) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoGenerator generator = new ManualLottoGenerator(numbers);
        lottoList.add(new Lotto(generator));
        return lottoList;
    }
}
