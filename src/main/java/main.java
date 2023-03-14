import casino.Casino;
import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        int[] winners = new int[6];
        Scanner in = new Scanner(System.in);
        System.out.println("구입 금액을 입력하세요.");
        int amount = in.nextInt();

        Casino casino = new Casino();
        List<Lotto> lottoTickets = casino.buyLottery(amount);
        System.out.println(lottoTickets.size()+"개를 구입 했습니다.");
        lottoTickets.forEach(i ->
                System.out.println(i.getLotteryNumbers()));

        Scanner in2 = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력하세요.");
        String inputString = in2.nextLine();

        HashSet<Integer> winningNumber = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            winningNumber.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        System.out.println(winningNumber);

        System.out.println("보너스 볼을 입력하세요.");
        int bonus = in2.nextInt();

        for(Lotto lotto : lottoTickets) {
            int result =
                    casino.lotteryStart(winningNumber, lotto, bonus);
            winners[result-1] ++;
        }

        System.out.println("3개 일치 (5000원) - "+winners[4]+"개");
        System.out.println("4개 일치 (50000원) - "+winners[3]+"개");
        System.out.println("5개 일치 (1500000원) - "+winners[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - "+winners[1]+"개");
        System.out.println("6개 일치 (2000000000원) - "+winners[0]+"개");

        float winningPrice =
                ((float) (winners[0]*2000000000 +
                winners[1]*30000000 +
                winners[2]*1500000 +
                winners[3]*50000 +
                winners[4]*5000)/amount-1)*100;

        System.out.println("총 수익율은 "+winningPrice+"%입니다");
    }
}
