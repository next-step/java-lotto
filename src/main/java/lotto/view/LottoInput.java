package lotto.view;

import lotto.domain.Money;
import lotto.domain.BuyLotto;
import lotto.domain.WinOfLotto;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInput {
    Scanner scan = new Scanner(System.in);

    public BuyLotto getbuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        BuyLotto buyLotto = new BuyLotto(new Money(scan.nextInt()));

        System.out.println(buyLotto.getCount() + "개를 구매했습니다.");

        return buyLotto;
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
