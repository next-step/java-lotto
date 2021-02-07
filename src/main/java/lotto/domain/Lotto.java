package lotto.domain;

import java.util.*;

public class Lotto {

    static final int LOTTO_NUMBER_SIZE = 6;
    static final String DELIMITER = "[ ,]+";

    private final List<LottoNumber> numbers;

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSizeOfLotto(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getAsIntegerList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        numbers.forEach(lottoNumber -> {
            lottoNumberList.add(lottoNumber.getLottoNumber());
        });
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    public static Lotto of (List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public static void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if (lottoNumbersChecker.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }
    }
    public int getMatchedCount(Lotto lotto) {
        return (int) lotto.numbers.stream().filter(this::contains).count();
    }
    boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
