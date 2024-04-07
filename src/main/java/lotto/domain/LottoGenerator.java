package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static Lottos createLottos(List<String> textLottos, int autoCount) {
        List<Lotto> lottoList = createPassiveLottos(textLottos);
        lottoList.addAll(createAutoLottos(autoCount));
        return new Lottos(lottoList);
    }

    private static List<Lotto> createAutoLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(createLotto(shuffleLotto()));
        }

        return lottos;
    }

    private static List<Lotto> createPassiveLottos(List<String> textLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (String textLotto : textLottos) {
            lottos.add(createLotto(StringUtils.splitTextWinNumbers(textLotto)));
        }

        return lottos;
    }

    public static Lotto createLotto(String[] textLotto) {
        return new Lotto(textLotto);
    }

    public static Lotto createLotto(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public static List<Integer> shuffleLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int number = LottoBall.MIN_LOTTO; number <= LottoBall.MAX_LOTTO; number++) {
            lottoNumbers.add(number);
        }

        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, Lotto.LOTTO_SIZE);
    }

}
