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
        this(Arrays.stream(stringLottoNumbers.split(DELIMITER))
                   .map(number -> new LottoNumber(Integer.parseInt(number)))
                   .collect(Collectors.toList()));
    }

    public LottoNumbers(Integer... integerLottoNumbers) {
        this(Arrays.stream(integerLottoNumbers)
                   .map(number -> new LottoNumber(number))
                   .collect(Collectors.toList()));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;

    }

    public void validate(List<LottoNumber> lottoNumbers) {
        if (!lengthCheck(lottoNumbers)) {
            throw new IllegalArgumentException("숫자 6개 만 입력해주세요");
        }
        if (!duplicateValueCheck(lottoNumbers)) {
            throw new IllegalArgumentException("중복되는 값이 있습니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private boolean lengthCheck(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_NUMBERS_LENGTH;
    }

    private boolean duplicateValueCheck(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() == lottoNumbers.size();
    }

    public int countDuplicateNumber(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream().filter(lottoNumber -> winningNumbers.contains(lottoNumber)).count();
    }

    public static List<LottoNumbers> create(int numberOfLotto) {
        List<LottoNumbers> allLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            LottoNumbers newLottoNumbers = LottoNumbers.createSingleLottoNumbers();
            allLottoNumbers.add(newLottoNumbers);
        }
        return allLottoNumbers;
    }

    private static LottoNumbers createSingleLottoNumbers() {
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
