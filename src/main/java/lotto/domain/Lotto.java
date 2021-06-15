package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    final static String WHITE_SPACE = " ";
    final static String EMPTY = "";
    final static String COMMA_DELIMITER = ",";

    private Set<Integer> lottoNumbers;

    public Lotto(String lottoNumbersStr) {
        Set<Integer> lottoNumbers = new LinkedHashSet<>();
        for (String lottoNumberStr : lottoNumbersStr.replace(WHITE_SPACE, EMPTY).split(COMMA_DELIMITER)) {
            int lottoNumber = Integer.parseInt(lottoNumberStr);
            Lotto.throwIllegalArgumentException_lottoRange(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        throwIllegalArgumentException_lottoSize(lottoNumbers);

        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        this.lottoNumbers = lottoNumbers;

    }

    public Lotto(Set<Integer> lottoNumbers) {

        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        throwIllegalArgumentException_lottoSize(lottoNumbers);
        for (int lottoNumber : lottoNumbers) {
            throwIllegalArgumentException_lottoRange(lottoNumber);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private static void throwIllegalArgumentException_lottoSize(Set<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LottoConstants.NUMBER_COUNT_PER_GAME) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다.");
        }
    }

    private static void throwIllegalArgumentException_lottoRange(int lottoNumber) {
        if (lottoNumber < LottoConstants.LOTTO_MIN_NUM || lottoNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }
}
