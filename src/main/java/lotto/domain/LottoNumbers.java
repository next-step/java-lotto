package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private static final String DELIMITER = ",";

    private static final List<LottoNumber> allLottoNumber;

    static {
        allLottoNumber = initializeAllLottoNumber();
    }

    private List<LottoNumber> lottoNumbers;

    private static List<LottoNumber> initializeAllLottoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    public LottoNumbers(String stringLottoNumbers) {
        this.lottoNumbers = Arrays.stream(stringLottoNumbers.split(DELIMITER))
                                  .map(number -> new LottoNumber(Integer.parseInt(number)))
                                  .collect(Collectors.toList());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                           .anyMatch(singleLottoNumber -> singleLottoNumber.equals(lottoNumber));
    }

    public void validate() {
        if (!lengthCheck()) {
            throw new IllegalArgumentException("6개 이상의 숫자를 입력해주세요.");
        }
        if (!duplicateValueCheck()) {
            throw new IllegalArgumentException("중복되는 값이 있습니다.");
        }
    }

    private boolean lengthCheck() {
        return lottoNumbers.size() == LOTTO_NUMBERS_LENGTH;
    }

    private boolean duplicateValueCheck() {
        return lottoNumbers.stream().distinct().count() == lottoNumbers.size();
    }

    public int countDuplicateNumber(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream().filter(lottoNumber -> winningNumbers.contains(lottoNumber)).count();
    }

    public static LottoNumbers create() {
        Collections.shuffle(allLottoNumber);
        List<LottoNumber> newLottoNumbers = allLottoNumber.stream().limit(LOTTO_NUMBERS_LENGTH).collect(Collectors.toList());
        Collections.sort(newLottoNumbers);
        return new LottoNumbers(newLottoNumbers);
    }

    public String toString() {
        return "[" + lottoNumbers.stream()
                                 .map(lottoNumber -> lottoNumber.toString())
                                 .collect(Collectors.joining(", "))
               + "]";
    }
}
