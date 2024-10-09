package lotto.ticket;

import java.util.List;

public class LottoTicket {
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<Integer> lottoNumbers) {
        validateNumberOfLottoNumbers(lottoNumbers);
        validateNoDuplicateNumbers(lottoNumbers);
        validateNumberRange(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static void validateNumberOfLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() == NUMBER_OF_LOTTO_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 6개 입니다.");
    }

    private static void validateNoDuplicateNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() == lottoNumbers.size()) {
            return;
        }
        throw new IllegalArgumentException("로또 번호로 중복된 수를 사용할 수 없습니다.");
    }

    private static void validateNumberRange(List<Integer> lottoNumbers) {
        boolean isValidNumbers = lottoNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        if (isValidNumbers) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다.");
    }

    public boolean match(int targetNumber) {
        return lottoNumbers.contains(targetNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
