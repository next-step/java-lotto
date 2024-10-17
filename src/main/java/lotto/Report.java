package lotto;

public class Report {

    private final WinningRules winningRules;

    public Report(WinningRules winningRules) {
        this.winningRules = winningRules;
    }


    /**
     * 당첨 통계
     * ---------
     * 3개 일치 (5000원)- 1개
     * 4개 일치 (50000원)- 0개
     * 5개 일치 (1500000원)- 0개
     * 6개 일치 (2000000000원)- 0개
     */
    public String reportWinners(Statistics statistics) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");

        for (WinningRule winningRule : winningRules.getAllRules()) {
            builder.append(String.format("%d개 일치 (%d원)- %d개\n",
                    winningRule.getMatch(),
                    winningRule.getReward(),
                    statistics.get(winningRule.getMatch()))
            );
        }

        String result = builder.toString();
        System.out.println(result);
        return result;
    }
}
