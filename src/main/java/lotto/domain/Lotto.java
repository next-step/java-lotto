package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private static final String DELIMITER = ",";

    private Set<LottoNumber> lotto;

    public Lotto(String stringLotto) {
        this(Arrays.stream(stringLotto.split(DELIMITER))
                   .map(number -> LottoNumber.of(Integer.parseInt(number.trim())))
                   .collect(Collectors.toSet()));
    }


    public Lotto(Integer... integerLotto) {
        this(Arrays.stream(integerLotto)
                   .map(number -> LottoNumber.of(number))
                   .collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public void validate(Set<LottoNumber> lotto) {
        if (!lengthCheck(lotto)) {
            throw new IllegalArgumentException("숫자 6개 만 입력해주세요");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    private boolean lengthCheck(Set<LottoNumber> lotto) {
        return lotto.size() == LOTTO_NUMBERS_LENGTH;
    }

    public int countDuplicateNumber(Lotto winningNumbers) {
        return (int) lotto.stream().filter(lottoNumber -> winningNumbers.contains(lottoNumber)).count();
    }

    public static List<Lotto> lottoFactoryForAuto(int numberOfLotto) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            allLotto.add(AllLottoNumber.randomLottoNumber());
        }
        return allLotto;
    }

    public static List<Lotto> lottoFactoryForManual(List<String> manualLottos) {
        List<Lotto> allLotto = new ArrayList<>();
        for (String lottoNumbers : manualLottos) {
            allLotto.add(new Lotto(lottoNumbers));
        }
        return allLotto;
    }

    public String toString() {
        return "[" + lotto.stream()
                          .sorted()
                          .map(lottoNumber -> lottoNumber.toString())
                          .collect(Collectors.joining(", "))
               + "]";
    }
}
