package com.fineroot.lotto.view;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.viewmodel.InputViewModel;
import java.util.Scanner;

public class InputView {

    private final InputViewModel inputViewModel;

    public InputView(InputViewModel inputViewModel){
        this.inputViewModel = inputViewModel;
    }

    public void drawInputMoneyView(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        inputViewModel.saveMoney(Money.from(scanner.nextInt()));
    }

    public void drawInputWinningNumberView(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        inputViewModel.saveWinningNumber(WinningNumber.from(scanner.nextLine()));
        System.out.println("보너스 볼을 입력해 주세요.");
        inputViewModel.saveBonusNumber(LottoNumber.from(scanner.nextInt()));
        System.out.println();
    }
}
