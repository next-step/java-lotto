package com.fineroot.lotto.view;

import com.fineroot.lotto.domain.LottoBundle;
import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.domain.LottoPayment;
import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.viewmodel.InputViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final InputViewModel inputViewModel;

    public InputView(InputViewModel inputViewModel) {
        this.inputViewModel = inputViewModel;
    }

    public void drawLotteryPurchaseView() {
        drawInputMoneyView();
        drawInputManualLotteryCountView();
        drawInputManualLotteryBundleView();
    }

    private void drawInputMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        inputViewModel.saveLottoPayment(LottoPayment.from(scanner.nextInt()));
        System.out.println();
    }

    private void drawInputManualLotteryCountView() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        inputViewModel.saveManualPurchaseCount(LotteryCount.from(scanner.nextInt()));
        System.out.println();
    }

    private void drawInputManualLotteryBundleView() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; inputViewModel.manualLotteryIsGreaterThan(i); i++) {
            stringList.add(scanner.nextLine());
        }
        inputViewModel.saveManualLottoBundle(LottoBundle.fromList(stringList));
        System.out.println();
    }

    public void drawInputWinningNumberView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        inputViewModel.saveWinningNumber(WinningNumber.from(scanner.nextLine()));
        System.out.println("보너스 볼을 입력해 주세요.");
        inputViewModel.saveBonusNumber(LottoNumber.from(scanner.nextInt()));
        System.out.println();
    }
}
