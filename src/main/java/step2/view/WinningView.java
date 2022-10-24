package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step2.domain.WinningResult;

public class WinningView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String SEPARATOR = ", ";

    private WinningView() {

    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return Arrays.stream(SCANNER.nextLine().split(SEPARATOR))
                .map(Integer::parseUnsignedInt)
                .collect(Collectors.toList());
    }

    public static void printWinningResult(WinningResult winningResult, int purchasedValue) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningResult.getThreeMatches() + "개");
        System.out.println("4개 일치 (50000원) - " + winningResult.getFourMatches() + "개");
        System.out.println("5개 일치 (1500000원) - " + winningResult.getFiveMatches() + "개");
        System.out.println("6개 일치 (20000000000원) - " + winningResult.getSixMatches() + "개");
        System.out.println("총 수익률은 " + winningResult.getRateOfReturn(purchasedValue) + "입니다.");
    }
}
