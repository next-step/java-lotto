package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoConsole {

    private static final Scanner sc = new Scanner(System.in);

    public static void start() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyAmount = Integer.parseInt(sc.nextLine());

        Money money = new Money(moneyAmount);
        List<Lotto> _lottos = LottoStore.sellAsMuchAsPossible(money);
        System.out.printf("%d개를 구매했습니다.\n", _lottos.size());

        for (Lotto lotto : _lottos) {
            String lottoStr = lotto.balls().stream().mapToInt(Ball::number).mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoStr);
        }

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String strLottoNumbers = sc.nextLine();

        Set<Ball> balls = Arrays.stream(strLottoNumbers.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .map(Ball::new)
            .collect(Collectors.toSet());
        Lotto winningLotto = new Lotto(balls);

        Lottos lottos = new Lottos(_lottos);
        JudgeResult judgeResult = lottos.judge(winningLotto);

        System.out.println("당첨 통계\n---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", judgeResult.threeMatchCount());
        System.out.printf("4개 일치 (50000원)- %d개\n", judgeResult.fourMatchCount());
        System.out.printf("5개 일치 (1500000원)- %d개\n", judgeResult.fiveMatchCount());
        System.out.printf("6개 일치 (2000000000원)- %d개\n", judgeResult.sixMatchCount());

        System.out.printf("총 수익률은 %.2f입니다.", judgeResult.calcReturnRate(new Money(moneyAmount - money.amount())));
    }

    public static void main(String[] args) {
        start();
    }
}
