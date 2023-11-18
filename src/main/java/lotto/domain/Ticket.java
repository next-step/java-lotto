package lotto.domain;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

        private final LottoNumbers numbers;

        public Ticket(LottoNumbers numbers) {
                this.numbers = numbers;
        }

        public Ticket(int[] numbers) {
                this.numbers = new LottoNumbers(numbers);
        }

        public int[] numbers() {
                return numbers.values();
        }

        public int countWinningNumber(WinningNumbers winningNumbers) {
                AtomicInteger matchCount = new AtomicInteger();
                winningNumbers.values()
                    .forEach(value -> matchCount.set(matchCount.get() + getOneIfWinningNumberContained(value)));
                return matchCount.get();
        }

        private int getOneIfWinningNumberContained(int winningNumber) {
                if (Arrays.stream(numbers.values()).anyMatch(value -> value == winningNumber)) {
                        return 1;
                }
                return 0;
        }
}
