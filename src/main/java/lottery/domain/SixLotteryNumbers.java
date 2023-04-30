package lottery.domain;

import java.util.HashSet;
import java.util.Set;
import lottery.domain.numbergenerator.RandomNumberGenerator;

public class SixLotteryNumbers {

    private static final int LOTTERY_NUMBERS_SIZE = 6;

    private static final String INVALID_NUMBERS_MSG = "로또 번호는 총 6개의 숫자로 구성되어야합니다.";

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR =
            new RandomNumberGenerator();

    private final Set<LotteryNumber> lotteryNumbers;

    public SixLotteryNumbers() {
        this(authGeneratedSixNumbers());
    }

    public SixLotteryNumbers(Set<LotteryNumber> lotteryNumbers) {
        if(notHasSixNumbers(lotteryNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBERS_MSG);
        }
        this.lotteryNumbers = lotteryNumbers;
    }

    private static Set<LotteryNumber> authGeneratedSixNumbers() {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();
        while (lotteryNumbers.size() != 6) {
            lotteryNumbers.add(new LotteryNumber(RANDOM_NUMBER_GENERATOR.generatedNumber()));
        }
        return lotteryNumbers;
    }

    private boolean notHasSixNumbers(Set<LotteryNumber> lotteryNumbers) {
        return lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE;
    }

    public int size() {
        return lotteryNumbers.size();
    }

}
