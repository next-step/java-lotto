package lotto.view;

import lotto.domain.*;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInput {
    Scanner scan = new Scanner(System.in);

    public BuyLotto getBuyInfo() {
        return new BuyLotto(new Money(getBuyAmount()), new Count((getBuyPassiveCount())));
    }

    private int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }

    private int getBuyPassiveCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scan.nextInt();
    }

    public void enterPassiveNumbers(BuyLotto buyLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < buyLotto.getPassiveCount().getCount(); i++) {
            String passiveNumbersText = scan.next();
            Set<Integer> passiveNumbers = splitText(passiveNumbersText);
            Lotto lotto = new Lotto(passiveNumbers);
            buyLotto.putLottos(lotto);
        }
    }

    private Set<Integer> splitText(String text) {
        return Stream.of(text.split(",")).collect(Collectors.toSet())
                .stream().map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public WinOfLotto getWinOfLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winOfLottoNumbersText = scan.next();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scan.nextInt();

        Set<Integer> winOfLottoNumbers = Stream.of(winOfLottoNumbersText.split(",")).collect(Collectors.toSet())
                .stream().map(Integer::parseInt)
                .collect(Collectors.toSet());

        return new WinOfLotto(winOfLottoNumbers, bonus);
    }
}
