import java.util.*;

public class LottoAutoView {
    Scanner scanner = new Scanner(System.in);
    List<List> result;
    int price;
    List<Integer> countList = new ArrayList<>();
    List<Integer> bonusList = new ArrayList<>();
    LottoAutoService lotto;

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        price =  scanner.nextInt();
        System.out.println(price);

        int num = price/1000;
        System.out.println(num+"개를 구매했습니다.");

        lotto = new LottoAutoService(price,num);
        result = lotto.setLotto();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public void setWinningNum() {
        List<Integer> winningNum = new ArrayList<>();
        LottoAutoService lotto = new LottoAutoService();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        for(int i=0;i<6;i++) {
            winningNum.add(scanner.nextInt());
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scanner.nextInt();
        countList = lotto.statistic(result,winningNum);
        bonusList = lotto.statisticBonus(result,bonus);
    }

    public void setWinningStatistic(){
        System.out.println("당첨 통계");
        System.out.println("--------");

        WinningCount winningCount  = new WinningCount(countList, bonusList);
        winningCount.count();

        System.out.println("3개 일치 (5000원)- "+winningCount.three+"개");
        System.out.println("4개 일치 (50000원)- "+winningCount.four+"개");
        System.out.println("5개 일치 (1500000원)- "+winningCount.five+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "+winningCount.fiveBonus+"개");
        System.out.println("6개 일치 (2000000000원)- "+winningCount.six+"개");
        double revenue = lotto.revenue(winningCount);
        System.out.println("총 수익률은 "+revenue+"입니다.");
    }

}
