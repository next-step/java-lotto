package lotto.domain;

import java.util.List;

public class Ticket {

        private RandomNumbers numbers;
        private int matchCount;

        public Ticket(RandomNumbers numbers) {
                this.numbers = numbers;
        }

        public Rank rank() {
                return Rank.valueOfRank(matchCount);
        }

        public RandomNumbers numbers() {
                return numbers;
        }

        public int matchCount() {
                return matchCount;
        }

        public void matchInOneTicket(List<Integer> winningNumbers) {
                winningNumbers.forEach(this::addOneIfContained);
        }

        private void addOneIfContained(int winningNumber) {
                if (numbers.values().contains(winningNumber)) {
                        ++matchCount;
                }
        }
}
