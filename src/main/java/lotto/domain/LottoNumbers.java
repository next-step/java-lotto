package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "중복된 당첨 번호가 존재합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR = "당첨 번호는 6개 입력해주세요.";
    private static final String DEFAULT_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> DEFAULT_NUMBER_RANGE = IntStream.range(MIN_NUMBER, MAX_NUMBER)
                                                            .boxed()
                                                            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    public LottoNumbers() {
        this.numbers = createLottoNumbers();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public LottoNumbers(String inputNumbers) {
        this.numbers = createLottoNumbers(inputNumbers);
    }

    public LottoNumbers(int inputBonusNumber) {
        this.numbers = createBonusNumber(inputBonusNumber);
    }

    private List<LottoNumber> createBonusNumber(int inputBonusNumber) {
        return Arrays.asList(new LottoNumber(inputBonusNumber));
    }

    private List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(DEFAULT_NUMBER_RANGE);

        List<Integer> result = DEFAULT_NUMBER_RANGE.stream()
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
                    .distinct()
                    .count();

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }
    // 유효성 end.

    public List<LottoNumber> readOnlyNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean checkNumbers(List<LottoNumber> numbers) {
        return Objects.equals(numbers, this.numbers);
    }

    public static int matchOf(LottoTicket lottoTicket, LottoNumbers winnerNumber) {
        return (int) lottoTicket.lottoNumber()
                .stream()
                .filter(number -> numberContains(number, winnerNumber))
                .count();
    }

    public static boolean bonusOf(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        return lottoTicket.lottoNumber()
                .stream()
                .anyMatch(number -> number.checkNumber(bonusNumber));
    }

    public static boolean numberContains(LottoNumber number, LottoNumbers winnerNumber) {
        return winnerNumber.readOnlyNumbers().stream()
                .anyMatch(matchNumber -> number.checkNumber(matchNumber));
    }

}
