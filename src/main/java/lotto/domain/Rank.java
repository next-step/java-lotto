package lotto.domain;

import java.util.Arrays;

public enum Rank {
        FIRST(6, 2_000_000_000, false),
        SECOND(5, 30_000_000, true),
        THIRD(5, 1_500_000, false),
        FOURTH(4, 50_000, false),
        FIFTH(3, 5_000, false),
        MISS(0, 0, false);
    
        private int countOfMatch;
        private int winningMoney;
        private boolean isMatchBonus;
    
        private Rank(int countOfMatch, int winningMoney, boolean isMatchBonus) {
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
            this.isMatchBonus = isMatchBonus;
        }
    
        public int getCountOfMatch() {
            return countOfMatch;
        }
    
        public int getWinningMoney() {
            return winningMoney;
        }

        public boolean hasMatchBonus() {
            return isMatchBonus;
        }
            
        public static Rank valueOf(int countOfMatch, boolean matchBonus) {
            
            if (matchBonus) return SECOND;

            return Arrays.stream(values())
                            .filter(r -> countOfMatch == r.getCountOfMatch() && false == r.hasMatchBonus())
                            .findFirst()
                            .get();
        }
}