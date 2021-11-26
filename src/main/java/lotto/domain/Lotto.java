package lotto.domain;

import lotto.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String STRING_NUMBERS_DELIMITER = ",";
    private static final int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(pickRandomNumber());
    }

    private static List<LottoNumber> pickRandomNumber() {
        Set<LottoNumber> tmpLottoNumbers = new HashSet<>();
        while (tmpLottoNumbers.size() < NUMBER_COUNT) {
            tmpLottoNumbers.add(LottoNumber.valueOf(RandomUtil.randomInt(LottoNumber.MAX_VALUE)));
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(tmpLottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public Lotto(final String numbers) {
        this(Arrays.stream(numbers.split(STRING_NUMBERS_DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatch(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
