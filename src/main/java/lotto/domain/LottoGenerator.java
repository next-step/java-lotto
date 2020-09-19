package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.LOTTO_MAX;
import static lotto.domain.LottoNumber.LOTTO_MIN;

public class LottoGenerator {
    private static List<Integer> lottoNumbers = new ArrayList<>();
    private static final List<Integer> lottoSetting = new ArrayList<>();
    private static final int LOTTO_SIZE = 6;

    static {
        for(int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoSetting.add(i);
        }
    }

    public static List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.generateLotto(generateLottoNumber()));
        }
        return lottoList;
    }

    private static List<Integer> generateLottoNumber() {
        lottoNumbers.clear();
        Collections.shuffle(lottoSetting);
        for(int i = 0; i < LOTTO_SIZE; i++){
            lottoNumbers.add(lottoSetting.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
