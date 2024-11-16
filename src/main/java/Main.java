import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = scanner.nextLine();

        Money money = new Money(moneyStr);
        System.out.println(money.availLottoCount() + "개를 구매했습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator(new RandomGenerator());
        Candidates candidates = new Candidates();
        for(int i = 0; i < money.availLottoCount(); i++){
            Candidate candidate = new Candidate(lottoGenerator.generate());
            candidates.add(candidate);
            System.out.println(candidate.toString());
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningStr = scanner.nextLine();
        Lotto winning = new Lotto(winningStr);

        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원)- " + candidates.countByMatchCount(winning, new MatchCount(3)) + "개");
        System.out.println("4개 일치 (50000원)- " + candidates.countByMatchCount(winning, new MatchCount(4)) + "개");
        System.out.println("5개 일치 (1500000원)- " + candidates.countByMatchCount(winning, new MatchCount(5)) + "개");
        System.out.println("6개 일치 (2000000000원)- " + candidates.countByMatchCount(winning, new MatchCount(6)) + "개");
        System.out.println("총 수익률은 " + candidates.calculateRatio(winning));
    }
}
