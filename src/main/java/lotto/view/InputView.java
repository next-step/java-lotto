package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.dto.LottosDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static lotto.domain.Lottos.PRICE_PER_LOTTO;

public class InputView {
    private static final int NUMBERS_SIZE = 6;
    private static final int LAST_NUMBER_INDEX = 5;
    private final Scanner scanner;
    private final LottosDto lottos;
    private final int money;

    public InputView() {
        scanner = new Scanner(System.in);
        money = getMoney();
        lottos = new LottosDto(money, new Lottos(getManualLotto(getManualCount())));
        System.out.println("수동으로 " + lottos.manualSize() + "장, 자동으로 " + lottos.autoSize() + "개를 구매했습니다.");
        printNumbers();
        System.out.println();
    }

    private void printNumbers() {
        this.lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public Lottos getLottos() {
        return new Lottos(lottos.getLottos());
    }

    private int getMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private int getManualCount() {
        while (true) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int manualCount = scanner.nextInt();
            if (price(manualCount) <= money) {
                return manualCount;
            }
            System.out.println("구매 금액을 초과하여 입력할 수 없습니다.");
        }
    }

    private int price(int count) {
        return count * PRICE_PER_LOTTO;
    }

    private List<Lotto> getManualLotto(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = new ArrayList<>();
            IntStream.range(0, NUMBERS_SIZE)
                    .forEach(j -> numbers.add(parseInteger(j, scanner.next())));
            manualLottos.add(new Lotto(numbers));
        }
        return manualLottos;
    }

    public WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, NUMBERS_SIZE)
                .forEach(i -> list.add(parseInteger(i, scanner.next())));
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new WinningLotto(list, bonusNumber);
    }

    private Integer parseInteger(int i, String token) {
        if (i == LAST_NUMBER_INDEX) {
            return Integer.parseUnsignedInt(token);
        }
        return Integer.parseUnsignedInt(token.substring(0, token.length() - 1));
    }

}