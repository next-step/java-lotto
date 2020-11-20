package step2.view;


import step2.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void responseTicketAndCount(TicketAndCount ticketAndCount) {
        responseTicketCount(ticketAndCount);
        responseTickets(ticketAndCount);
    }

    public void responseTicketCount(TicketAndCount ticketAndCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", //
                ticketAndCount.manualSelectionCount, ticketAndCount.naturalSelectionCount);
    }

    public void responseTickets(TicketAndCount ticketAndCount) {
        ticketAndCount.ticketNumbers.forEach(System.out::println);
        System.out.println();
    }

    public void responseLotteryResult(LotteryResult lotteryResult) {
        responseWinningStat(lotteryResult);
        responseRateOfReturn(lotteryResult);
    }

    public void responseWinningStat(LotteryResult lotteryResult) {
        //@formatter:off
        System.out.println(
                "\n당첨 통계\n" +
                "---------");
        //@formatter:on
        System.out.println(toStringRank(Rank.FIFTH, lotteryResult));
        System.out.println(toStringRank(Rank.FORTH, lotteryResult));
        System.out.println(toStringRank(Rank.THIRD, lotteryResult));
        System.out.println(toStringRank(Rank.SECOND, lotteryResult));
        System.out.println(toStringRank(Rank.FIRST, lotteryResult));
    }

    public static String toStringRank(Rank rank, LotteryResult lotteryResult) {

        return String.format(toFormat(rank), //
                rank.getMatchingCount(),  //
                rank.getPrizeAmount().toInt(), //
                lotteryResult.getMatchResult(rank));
    }

    private static String toFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return "%d개 일치, 보너스 볼 일치(%d원) - %d개";
        }
        return "%d개 일치 (%d원)- %d개";
    }

    public void responseRateOfReturn(LotteryResult lotteryResult) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", lotteryResult.rateOfReturn);
    }

    public static class LotteryResult {
        private final float rateOfReturn;
        private final Map<Rank, Integer> matchResult;

        public LotteryResult(float rateOfReturn, Map<Rank, Integer> matchResult) {
            this.rateOfReturn = rateOfReturn;
            this.matchResult = matchResult;
        }

        public int getMatchResult(Rank rank) {
            return matchResult.getOrDefault(rank, 0);
        }
    }

    public static class TicketAndCount {
        private final int manualSelectionCount;
        private final int naturalSelectionCount;
        private final List<String> ticketNumbers;

        public TicketAndCount(int manualSelectionCount, int naturalSelectionCount, List<String> ticketNumbers) {
            this.manualSelectionCount = manualSelectionCount;
            this.naturalSelectionCount = naturalSelectionCount;
            this.ticketNumbers = ticketNumbers;
        }

        public static class Builder {
            private int manualSelectionCount;
            private int naturalSelectionCount;
            private List<String> ticketNumbers;

            public Builder manualSelectionCount(int manualSelectionCount) {
                this.manualSelectionCount = manualSelectionCount;
                return this;
            }

            public Builder naturalSelectionCount(int naturalSelectionCount) {
                this.naturalSelectionCount = naturalSelectionCount;
                return this;
            }

            public Builder ticketNumbers(List<String> ticketNumbers) {
                this.ticketNumbers = ticketNumbers;
                return this;
            }

            public TicketAndCount build() {
                return new TicketAndCount(manualSelectionCount, naturalSelectionCount, ticketNumbers);
            }
        }
    }
}
