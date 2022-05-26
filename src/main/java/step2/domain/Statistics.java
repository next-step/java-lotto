package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private final int[] reward = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private int[] statistics;

    public Statistics(int[] statistics) {
        this.statistics = statistics;
    }

    public String getMatchInfos() {

        List<String> matchInfos = new ArrayList<>();

        for (int i = 3; i <= 6; i++) {
            matchInfos.add(String.format("%d개 일치 (%d원)- %d개", i, reward[i], statistics[i]));
        }

        return String.join("\n", matchInfos);
    }

    public String getRateOfReturn(int purchase) {
        int res = 0;
        for (int i = 3; i <= 6; i++) {
            res += reward[i] * statistics[i];
        }
        double ror = (res - purchase) / (double)purchase;
        return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", ror);
    }
}
