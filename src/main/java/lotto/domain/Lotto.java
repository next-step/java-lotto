package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    final static String WHITE_SPACE = " ";
    final static String EMPTY = "";
    final static String COMMA_DELIMITER = ",";

    private Set<LottoNumber> lottoNumbers;

    public Lotto(String lottoNumbersStr) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (String lottoNumberStr : lottoNumbersStr.replace(WHITE_SPACE, EMPTY).split(COMMA_DELIMITER)) {
            LottoNumber lottoNumber = new LottoNumber(Integer.parseInt(lottoNumberStr));
             lottoNumbers.add(lottoNumber);
        }
        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(TreeSet::new));

        this.lottoNumbers = lottoNumbers;

    }

    public Lotto(Set<LottoNumber> lottoNumbers) {

        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        throwIllegalArgumentException_lottoSize(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private static void throwIllegalArgumentException_lottoSize(Set<LottoNumber> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LottoConstants.NUMBER_COUNT_PER_GAME) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다.");
        }
    }

}
