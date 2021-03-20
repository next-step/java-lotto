package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumbers {
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = "중복된 당첨 번호가 존재합니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = "당첨 번호는 6개 입력해주세요.";
    private static final String DEFAULT_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
                                                            .boxed()
                                                            .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = createLottoNumbers();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String inputNumbers) {
        this.lottoNumbers = createLottoNumbers(inputNumbers);
    }

    public LottoNumbers(int inputBonusNumber) {
        this.lottoNumbers = createBonusNumber(inputBonusNumber);
    }

    private List<LottoNumber> createBonusNumber(int inputBonusNumber) {
        return Arrays.asList(new LottoNumber(inputBonusNumber));
    }

    private List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<Integer> result = LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> createLottoNumbers(String numbers) {
        List<LottoNumber> result = stringToList(numbers).stream()
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        isDuplicateNumbers(result);
        isLottoNumberCount(result);

        return result;
    }

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    // 유효성 start.
    private void isLottoNumberCount(List<LottoNumber> result) {
        if (result.size() != LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void isDuplicateNumbers(List<LottoNumber> result) {
        int count = (int) result.stream()
                .mapToInt(LottoNumber::lottoNumber)
                .distinct()
                .count();

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }
    // 유효성 end.

    public List<LottoNumber> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean checkNumbers(List<LottoNumber> numbers) {
        return Objects.equals(numbers, lottoNumbers);
    }

    public static int matchOf(LottoTicket lottoTicket, LottoNumbers winnerNumber) {
        return (int) lottoTicket.lottoNumber()
                .stream()
                .filter(number -> numberContains(number.lottoNumber(), winnerNumber))
                .count();
    }

    public static boolean numberContains(int number, LottoNumbers winnerNumber) {
        return winnerNumber.readOnlyNumbers().stream()
                .anyMatch(matchNumber -> number == matchNumber.lottoNumber());
    }

}
