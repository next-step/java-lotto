package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<LottoNumber> enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] split = new Scanner(System.in).nextLine().split(", ");
        return Arrays.stream(split).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());
    }

    public Integer enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Lotto> enterMenualNumbers(int menualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < menualCount; i++) {
            String[] split = new Scanner(System.in).nextLine().split(", ");
            List<LottoNumber> collect = Arrays.stream(split).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());
            lottoList.add(new Lotto(collect));

        }
        return lottoList;

    }

    public int enterMenualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return scanner.nextInt();
    }
}
