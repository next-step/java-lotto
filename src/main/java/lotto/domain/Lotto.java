package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    final static String WHITE_SPACE = " ";
    final static String EMPTY = "";
    final static String COMMA_DELIMITER = ",";


    private List<Integer> lottoNumbers;

    public Lotto(String lottoNumbersStr) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumberStr : lottoNumbersStr.replace(WHITE_SPACE, EMPTY).split(COMMA_DELIMITER)) {
            int lottoNumber = Integer.valueOf(lottoNumberStr);
            Lotto.throwIllegalArgumentException_lottoRange(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        throwIllegalArgumentException_lottoSize(lottoNumbers);

        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;

    }

    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        throwIllegalArgumentException_lottoSize(lottoNumbers);
        for (int lottoNumber : lottoNumbers) {
            throwIllegalArgumentException_lottoRange(lottoNumber);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static void throwIllegalArgumentException_lottoSize(List<Integer> winningLottoNumbers) {
        if (new HashSet<>(winningLottoNumbers).size() != LottoConstants.LOTTO_SELECT_NUM) {
            throw new IllegalArgumentException("로또 번호는 6개여야한다, 중복된 숫자가 들어가서는 안됩니다.");
        }
    }

    public static void throwIllegalArgumentException_lottoRange(int lottoNumber) {
        if (lottoNumber < LottoConstants.LOTTO_MIN_NUM || lottoNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }
}
