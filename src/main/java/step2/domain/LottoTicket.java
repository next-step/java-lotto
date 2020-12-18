package step2.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final static String LOTTO_DUPLICATION_EXCEPTION = "로또 번호는 중복되지 않는 6개의 번호로 입력 가능합니다.";
    private final static String LOTTO_NULL_EXCEPTION = "당첨번호는 빈 값을 입력할 수 없습니다.";
    private final static String DELIMITER = ",";
    private final static int LOTTO_NUMBERS_CONDITION = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER = "유효한 로또 번호가 아닙니다.";

    private final Set<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new HashSet<>();
    }

    public LottoTicket(String inputLottoNumbers) {
        this(convertToSet(validateNullOrEmpty(inputLottoNumbers)));
    }

    private LottoTicket(Set<Integer> lottoNumbers) {
        validateMoreThanSix(lottoNumbers);
        validateInputNumberMaxAndMin(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    static String validateNullOrEmpty(String inputLottoNumbers) {
        if (Objects.isNull(inputLottoNumbers) || inputLottoNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(LOTTO_NULL_EXCEPTION);
        }
        return inputLottoNumbers;
    }

    private static Set<Integer> convertToSet(String inputLottoNumbers) {
        String[] splitLottoNumbers = inputLottoNumbers.split(DELIMITER);
        return Stream.of(splitLottoNumbers)
                .map(Integer::new)
                .collect(Collectors.toSet());
    }

    static void validateMoreThanSix(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_CONDITION) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    static void validateInputNumberMaxAndMin(Set<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
            }
        }
    }

    public LottoTicket buyAuto() {
        return new LottoTicket(new RandomLottoNumber().getLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public WinningRank checkWinningRank(LottoTicket winningLottoTicket) {
        long matchingCount = winningLottoTicket.getLottoNumbers()
                .stream()
                .filter(winningNumber -> this.lottoNumbers.contains(winningNumber))
                .count();
        return WinningRank.findRanking(matchingCount);
    }
}