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
                winningNumbers.values()
                    .forEach(value -> matchCount.set(matchCount.get() + getOneIfWinningNumberContained(value)));
                return matchCount.get();
        }

        public boolean isBonusNumberContained(WinningNumbers winningNumbers) {
                return numbers.isBonusNumberContained(winningNumbers.bonusNumber());
        }

        private int getOneIfWinningNumberContained(int winningNumber) {
                if (numbers.isWinningNumberContained(winningNumber)) {
                        return 1;
                }
                return 0;
        }
}
