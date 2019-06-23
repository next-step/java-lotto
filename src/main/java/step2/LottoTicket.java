package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket from() {
        List<Integer> lottoBalls = pickSixBalls(generateLottoBalls());
        return new LottoTicket(lottoBalls);
    }

    public static List<Integer> pickSixBalls(List<Integer> lottoBalls) {
        return lottoBalls.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public static List<Integer> generateLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoBalls.add(i);
        }
        Collections.shuffle(lottoBalls);
        return lottoBalls;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
