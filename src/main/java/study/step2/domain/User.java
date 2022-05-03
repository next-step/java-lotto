package study.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class User {
    private User() {
    }

    public static Map<String, Long> analyzeLottoNumber(List<Ticket> tickets, List<Integer> inputLastWeekLottoNumber) {
        long threeCount = 0;
        long fourCount = 0;
        long fiveCount = 0;
        long sixCount = 0;
        long sum = 0;
        int length = tickets.size();
        for (int i = 0; i < length; i++) {
            long matchCount = tickets.get(i).getTicket().stream()
                    .filter(old -> inputLastWeekLottoNumber.stream().anyMatch(Predicate.isEqual(old)))
                    .count();
            if (matchCount == 3) {
                threeCount++;
                sum+=5000;
            }
            if (matchCount == 4) {
                fourCount++;
                sum+=50000;
            }
            if (matchCount == 5) {
                fiveCount++;
                sum+=1500000;
            }
            if (matchCount == 6) {
                sixCount++;
                sum+=2000000000;
            }
        }
        Map<String, Long> map = new HashMap<>();
        map.put("three", threeCount);
        map.put("four", fourCount);
        map.put("five", fiveCount);
        map.put("six", sixCount);
        map.put("sum", sum);
        return map;
    }
}
