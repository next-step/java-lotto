package domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        double price = in.nextDouble();
        System.out.println((int) (price / 1000) + "개를 구매했습니다.");
        Lotto lotto = new Lotto(price);
        for (List<Integer> i : lotto.allLotto.lottoPapers) {
            System.out.println(i);
        }
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        in.nextLine();
        String winning_number = in.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus_number = in.nextInt();
        ComparisonLottoNumber comparisonLottoNumber = new ComparisonLottoNumber();
        List<Integer> resultCount = comparisonLottoNumber.comparison(lotto.allLotto, winning_number,bonus_number);
        Rank rank = new Rank();
        List<Match> matches = rank.rankCondition(resultCount);
        RankCount rankCount = new RankCount();
        HashMap<Integer,Integer> result = rankCount.run(matches);
        Revenue revenue = new Revenue();
        double revenueRate =revenue.statistics(14000,result);
        System.out.println("당첨 통계\n" +"---------");
        System.out.println("3개 일치 (5000원)-" +result.get(5000)+"개");
        System.out.println("4개 일치 (50000원)- " +result.get(50000)+"개");
        System.out.println("5개 일치 (1500000원)- " +result.get(1500000)+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) -" +result.get(30000000)+"개");
        System.out.println("6개 일치 (2000000000원)-" +result.get(2000000000)+"개");
        System.out.println("총 수익률은 "+revenueRate+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

    }
}
