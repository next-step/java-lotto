package lottery.domain;

import lottery.dto.LotteryNumbersDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumbers {

    static final int LOTTERY_SIZE = 6;

    private final List<LotteryNumber> numbers;

    public LotteryNumbers(List<Integer> numberList) {
        List<LotteryNumber> lotteryNumbers =
            numberList.stream().map(LotteryNumber::new).collect(Collectors.toList());
        validate(lotteryNumbers);
        this.numbers = lotteryNumbers;
    }

    private void validate(List<LotteryNumber> numbers) {
        validateLotteryNumberSize(numbers);
        validateDuplicates(numbers);
    }

    private void validateLotteryNumberSize(List<LotteryNumber> numbers) {
        if (numbers.size() != LOTTERY_SIZE) {
            throw new IllegalArgumentException("로또 하나는 여섯 개의 번호로 구성되어야 합니다.");
        }
    }

    private void validateDuplicates(List<LotteryNumber> numbers) {
        Set<LotteryNumber> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public boolean contain(LotteryNumber lotteryNumber) {
        return numbers.contains(lotteryNumber);
    }

    public long countMatchedNumbers(LotteryNumbers lotteryNumbers) {
        return this.numbers.stream()
                           .filter(lotteryNumbers.numbers::contains)
                           .count();
    }

    public LotteryNumbersDto export() {
        List<Integer> rawNumbers = numbers.stream()
                                          .map(LotteryNumber::export)
                                          .collect(Collectors.toList());
        return new LotteryNumbersDto(rawNumbers);
    }

}
