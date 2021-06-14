package lotto;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGameMain {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int payMoney = scanner.nextInt();

        LottoCreater lottoCreater = new LottoCreater(payMoney);

        for (LottoTicket lottoTicket : lottoCreater.getLottoTickets()) {
            System.out.println(lottoTicket.getLottoTicket());
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        WinningNumbers winningNumbers = new WinningNumbers(scanner.nextLine());
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = scanner.nextInt();

        WinningCheck winningCheck =
                new WinningCheck(lottoCreater.getLottoTickets(), winningNumbers.getWinningNumbers(), bonusBall);

        System.out.println("당첨 통계");
        System.out.println("------------");

        Map<Rank, Long> rankCountMap = winningCheck.getRankList().stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        winningCheck.nullToZero(rankCountMap);

        System.out.println(Rank.FIFTH.getMatchCount() + "개 일치 (" + Rank.FIFTH.getPrice() + "원) - " + rankCountMap.get(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getMatchCount() + "개 일치 (" + Rank.FOURTH.getPrice() + "원) - " + rankCountMap.get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getMatchCount() + "개 일치 (" + Rank.THIRD.getPrice() + "원) - " + rankCountMap.get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getMatchCount() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrice() + "원) - " + rankCountMap.get(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getMatchCount() + "개 일치 (" + Rank.FIRST.getPrice() + "원) - " + rankCountMap.get(Rank.FIRST) + "개");

        double yield = winningCheck.getProceeds(rankCountMap) / payMoney;

        System.out.println("총 수익률은 " + Math.floor(yield * 100) / 100.0 + "입니다.");
    }
}
