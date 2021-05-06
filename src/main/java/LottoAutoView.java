import java.util.*;

public class LottoAutoView {
    Scanner scanner = new Scanner(System.in);

    int price;
    int quantity;

    LottoAutoService lottoAuto;
    List<List> lottoAutoNumbers;

    //List<Integer> winningNumbers;= new ArrayList<>();

    List<Integer> countList = new ArrayList<>();
    List<Integer> bonusList = new ArrayList<>();

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        price = scanner.nextInt();

        outputLottoAutoNumbers();
    }

    private void outputLottoAutoNumbers() {
        quantity = price / 1000;
        System.out.println(quantity + "개를 구매했습니다.");

        lottoAuto = new LottoAutoService(price, quantity);
        lottoAutoNumbers = lottoAuto.setLottoAutoNumbers();

        for (int i = 0; i < lottoAutoNumbers.size(); i++) {
            System.out.println(lottoAutoNumbers.get(i));
        }
    }

    public void inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();

        lottoAuto.setWinningNumbers(winningNumbers);
        lottoAuto.setBonusNumber(bonusNumber);
        //countList = lottoAuto.statistic(lottoAutoNumbers, winningNumbers);
        //bonusList = lottoAuto.statisticBonus(lottoAutoNumbers, bonus);
        outputWinningStatistic();
    }

    public void outputWinningStatistic() {
        System.out.println("당첨 통계");
        System.out.println("--------");

        List<Integer> winningResult = lottoAuto.collectWinningResult();
        System.out.println("3개 일치 (5000원)- " + winningResult.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + winningResult.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + winningResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + winningResult.get(3) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningResult.get(4) + "개");
        double earningRate = lottoAuto.setEarningRate();
        System.out.println("총 수익률은 "+earningRate+"입니다.");
        /*
        WinningCount winningCount = new WinningCount(countList, bonusList);
        winningCount.count();

        System.out.println("3개 일치 (5000원)- " + winningCount.three + "개");
        System.out.println("4개 일치 (50000원)- " + winningCount.four + "개");
        System.out.println("5개 일치 (1500000원)- " + winningCount.five + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + winningCount.fiveBonus + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningCount.six + "개");
        double revenue = lottoAuto.revenue(winningCount);
        System.out.println("총 수익률은 " + revenue + "입니다.");
         */
    }

}
