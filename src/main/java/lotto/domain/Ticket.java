package lotto.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

        private final LottoNumbers numbers;

        public Ticket(LottoNumbers numbers) {
                this.numbers = numbers;
        }

        public int[] numbers() {
                return numbers.values().stream().mapToInt(LottoNumber::value).toArray();
        }

        public int countWinningNumber(WinningNumbers winningNumbers) {
                AtomicInteger matchCount = new AtomicInteger();
                winningNumbers.basicWinningNumbers()
                    .forEach(value -> matchCount.set(matchCount.get() + getOneIfWinningNumberContained(value)));
                matchCount.set(matchCount.get() + getOneIfWinningNumberContained(winningNumbers.bonusNumber()));
                return matchCount.get();
        }

        public boolean hasBonusNumber(WinningNumbers winningNumbers) {
                return numbers.hasMatchingNumber(winningNumbers.bonusNumber());
        }

        private int getOneIfWinningNumberContained(LottoNumber winningNumber) {
                if (numbers.hasMatchingNumber(winningNumber)) {
                        return 1;
                }
                return 0;
        }
}
