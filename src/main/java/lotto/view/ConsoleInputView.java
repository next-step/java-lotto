package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {

    @Override
    public int purchase() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        int payment = scanner.nextInt();
        int lottoCount = payment / 1000;
        System.out.println(lottoCount + "개를 구입했습니다.");
        return lottoCount;
    }

    public Lotto pastLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String winningLottoString = scanner.nextLine();
        Lotto winningLotto = makeWinningLotto(winningLottoString);
        System.out.println();
        return winningLotto;
    }

    private Lotto makeWinningLotto(String pastLottoString) {
        String[] pastLottoArr = pastLottoString.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String pastLottoNo : pastLottoArr) {
            lotto.add(Integer.parseInt(pastLottoNo.trim()));
        }
        return new Lotto(lotto);
    }
}
