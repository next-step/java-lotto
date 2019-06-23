package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    public List<Integer> pickSixBalls(List<Integer> lottoBalls) {
        return lottoBalls.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public List<Integer> generateLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoBalls.add(i);
        }
        Collections.shuffle(lottoBalls);
        return lottoBalls;
    }
}
