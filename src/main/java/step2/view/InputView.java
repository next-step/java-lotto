package step2.view;

import step2.domain.LottoNum;
import step2.domain.Winning;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private InputView() {}

    public static int buyLottosMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = scanner.nextLine().trim();
        int money = Integer.parseInt(line);
        if (money < 0) {
            throw new IllegalArgumentException("구매 금액은 음수 일 수 없습니다.");
        }
        return money;
    }

    public static Winning winningNumsLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<LottoNum> winningNums = getWinningNums();
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNum bonusNum = getBonusNum();
        return new Winning(winningNums, bonusNum);
    }

    private static Set<LottoNum> getWinningNums() {
        String[] tokens = scanner.nextLine().split(",");
        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNum::new)
                .collect(Collectors.toSet());
    }

    private static LottoNum getBonusNum() {
        return new LottoNum(scanner.nextInt());
    }



}
