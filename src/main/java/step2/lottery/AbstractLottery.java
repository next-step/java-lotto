package step2.lottery;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractLottery {
    protected final Set<LotteryNumber> lottoNumbers;
    private static final int LOTTO_LENGTH = 6;
    private static final String DELIMITER = ",";

    protected AbstractLottery(Set<LotteryNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers();
    }

    protected AbstractLottery(String input) {
        String[] parsedInput = validateInput(input);
        this.lottoNumbers = parseNumbers(parsedInput);
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호의 개수가 올바르지 않습니다.");
        }
    }

    public int matchCount(Set<LotteryNumber> otherNumbers) {
        return (int) lottoNumbers.stream().filter(otherNumbers::contains).count();
    }

    public Set<LotteryNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private String[] validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        return input.replace(" ", "").split(DELIMITER);
    }

    private Set<LotteryNumber> parseNumbers(String[] result) {
        Set<LotteryNumber> numbers = new HashSet<>();
        for (String number : result) {
            try {
                numbers.add(LotteryNumber.of(Integer.parseInt(number)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호가 숫자가 아닙니다.");
            }
        }
        return numbers;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractLottery) {
            return lottoNumbers.equals(((AbstractLottery) obj).lottoNumbers);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}