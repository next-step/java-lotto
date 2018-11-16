package net.chandol.lotto.endpoint;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoGame;
import net.chandol.lotto.domain.LottoGameResult;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.Money;
import net.chandol.lotto.value.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.chandol.lotto.type.LottoPrize.*;
import static net.chandol.lotto.view.ViewUtil.*;

public class ConsoleUi {

    public static PurchaseRequest inputPurchaseRequest() {
        Integer rawTotalPrice = getInputNumber("구매금액을 입력해주세요");
        Money totalPrice = Money.of(rawTotalPrice);

        Integer directCount = getInputNumber("수동으로 구매할 로또 수를 입력해 주세요.");
        List<String> rawLottoNumbers = getInputStringArrays(directCount, "수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumber> directLottoNumbers = getLottoNumbers(rawLottoNumbers);

        return new PurchaseRequest(totalPrice, directLottoNumbers);
    }


    public static WinningNumber inputWinningNumber() {
        String rawWinLottoNumber = getInputString("지난 주 당첨 번호를 입력해 주세요.");
        Integer bonusNumber = getInputNumber("보너스 볼을 입력해 주세요.");

        LottoNumber winLottoNumber = getLottoNumber(rawWinLottoNumber);
        return new WinningNumber(winLottoNumber, bonusNumber);
    }

    public static Integer getInputNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String getInputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }


    public static List<String> getInputStringArrays(int count, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        List<String> results = new ArrayList<>();

        for (int idx = 0; idx < count; idx++) {
            String line = scanner.nextLine();
            results.add(line);
        }

        return results;
    }

    public static void printLottoNumberAndCount(PurchaseRequest request, LottoGame lottoGame) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", request.getDirectLottoCount(), request.getAutoLottoCount()));

        for (Lotto lotto : lottoGame.getLottos()) {
            String formattedLottoNumber = formatLotto(lotto);
            System.out.println(formattedLottoNumber);
        }
    }

    public static void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(lottoGameResult.getFormattedResult(_5));
        System.out.println(lottoGameResult.getFormattedResult(_4));
        System.out.println(lottoGameResult.getFormattedResult(_3));
        System.out.println(lottoGameResult.getFormattedResult(_2));
        System.out.println(lottoGameResult.getFormattedResult(_1));

        Double profitRate = lottoGameResult.getProfitRate();
        System.out.println(String.format("총 수익률은 %.2f 입니다", profitRate));
    }
}
