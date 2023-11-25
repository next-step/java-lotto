package camp.nextstep.edu.lottery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(br.readLine());

        Lotteries lotteries = new Lotteries(money);
        System.out.printf("%d개를 구매했습니다.\n", lotteries.count());

        System.out.println(lotteries);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(br.readLine().split(",")).map(String::trim).map(Integer::valueOf).collect(
            Collectors.toList());
        Lottery win = new Lottery(numbers);

        System.out.print("\n당첨 통계\n---------\n");
        System.out.printf("3개 일치 (5000원)- %d개\n", lotteries.count5thPrize(win));
        System.out.printf("4개 일치 (50000원)- %d개\n", lotteries.count4thPrize(win));
        System.out.printf("5개 일치 (1500000원)- %d개\n", lotteries.count3rdPrize(win));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", lotteries.count1stPrize(win));
        System.out.printf("총 수익률은 %.2f입니다.", lotteries.calcReturnRate(win));
    }
}
