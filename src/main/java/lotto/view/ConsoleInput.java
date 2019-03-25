package lotto.view;

import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import spark.utils.StringUtils;

public class ConsoleInput {

    public static LottoMoney inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        LottoMoney lottoMoney = null;

        while (lottoMoney == null) {
            try {
                lottoMoney = new LottoMoney(scanner.nextLine());
            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
                System.out.println("구입금액이 잘못 입력되었습니다.");
                System.out.println("다시 구입금액을 입력해 주세요.");
            }
        }

        return lottoMoney;
    }

    public static LottoList inputManualLottos(final int limitLottoCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        LottoList lottoList = new LottoList();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (StringUtils.isBlank(input) || lottoList.size() == limitLottoCount) {
                break;
            }

            try {
                lottoList.add(new Lotto(input.split(", ")));

            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
                System.out.println("로또 번호 입력이 잘못 되었습니다.");
                System.out.println("다시 수동으로 구매할 번호를 입력해 주세요.");
            }
        }

        return lottoList;
    }

    public static WinningLotto inputLastWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Lotto lotto = null;
        while (lotto == null) {
            try {
                lotto = new Lotto(scanner.nextLine().split(", "));
            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
                System.out.println("지난 주 당첨 번호 입력이 잘못 되었습니다.");
                System.out.println("다시 지난 주 당첨 번호를 입력해 주세요.");
            }
        }

        System.out.println("보너스 볼을 입력해 주세요.");

        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            try {
                winningLotto = new WinningLotto(lotto, LottoNumber.from(scanner.nextLine()));
            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
                System.out.println("보너스 볼 입력이 잘못 되었습니다.");
                System.out.println("다시 보너스 볼을 입력해 주세요.");
            }
        }

        return winningLotto;
    }
}
