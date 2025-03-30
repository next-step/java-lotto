package step2.view;

import step2.domain.*;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = scanner.nextLine().trim();
        int money = Integer.parseInt(line);
        if (money < 0) {
            throw new IllegalArgumentException("음수 일 수 없습니다.");
        }
        return money;
    }

    public static LottosCount countLottos(int money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String line = scanner.nextLine().trim();
        int countManual = Integer.parseInt(line);
        if (countManual < 0) {
            throw new IllegalArgumentException("음수 일 수 없습니다.");
        }
        return new LottosCount(countManual, money);
    }

    public static List<Lotto> buyLottosManual(int manual) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manual; i++) {
            lottos.add(new Lotto(LottoFactory.fromSplit(scanner.nextLine())));
        }
        return lottos;
    }

    public static Winning winningNumsLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<LottoNum> winningNums = LottoFactory.fromSplit(scanner.nextLine());
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNum bonusNum = getBonusNum();
        return new Winning(winningNums, bonusNum);

    }

    private static LottoNum getBonusNum() {
        return new LottoNum(scanner.nextInt());
    }
}
