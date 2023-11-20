package com.fineroot.lotto.view;

import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.entity.LottoStore;
import java.util.Scanner;

public class InputView {

    private LottoStore lottoStore;

    public InputView(LottoStore lottoStore){
        this.lottoStore = lottoStore;
    }

    public void draw(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        Money money = Money.from(scanner.nextInt());
        lottoStore.preservePurchaseMoney(money);
    }
}
