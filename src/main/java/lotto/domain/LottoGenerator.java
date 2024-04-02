package lotto.domain;

import lotto.constant.Constants;
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
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto(shuffleLotto()));
        }

        return lottoList;
    }

    private static List<Lotto> createPassiveLottos(List<String> textLottos) {
        List<Lotto> lottoList = new ArrayList<>();

        for (String textLotto : textLottos) {
            lottoList.add(createLotto(StringUtils.splitTextWinNumbers(textLotto)));
        }

        return lottoList;
    }

    public static Lotto createLotto(String[] textLotto) {
        return new Lotto(textLotto);
    }

    public static Lotto createLotto(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public static List<Integer> shuffleLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int number = Constants.MIN_LOTTO; number <= Constants.MAX_LOTTO; number++) {
            lottoNumbers.add(number);
        }

        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, Constants.LOTTO_SIZE);
    }

}
