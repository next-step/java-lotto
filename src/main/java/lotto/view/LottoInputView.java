package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoInputView {

    private final Scanner scanner = new Scanner(System.in);

    public Lotto readBeforeWinLotto() {
        System.out.println("이전 로또 번호를 입력 해주세요");
        String text = scanner.nextLine();
        String[] lottoNumbers = text.replace(" ", "").split(",");

        return Lotto.ofString(lottoNumbers);
    }

    public LottoNumber readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return LottoNumber.of(bonusNumber);
    }


    public PurchaseInfo read() {
        int purchaseAmount = readPurchaseAmount();
        System.out.println();

        int manualCnt = readManualLottoPurchaseCount();
        System.out.println();

        List<String> manualLottoNumber = readManualLottoPurchaseNumber(manualCnt);

        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottoNumber);
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", purchaseInfo.getAutoLottoCount(), manualCnt));

        return purchaseInfo;
    }

    private List<String> readManualLottoPurchaseNumber(int manualCnt) {
        List<String> inputStr = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCnt; i++) {
            inputStr.add(scanner.nextLine());
        }

        return inputStr;
    }

    private int readManualLottoPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int cnt = scanner.nextInt();
        scanner.nextLine();
        return cnt;
    }

    private int readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        int pay = scanner.nextInt();
        scanner.nextLine();
        return pay;
    }
}
