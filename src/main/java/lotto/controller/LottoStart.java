package lotto.controller;

import lotto.domain.LottoCreator;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Scanner;

public class LottoStart {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoCreator lottoCreator = new LottoCreator();

        outputView.payAmount();
        inputView.countLotto();

        outputView.lastWeekNumbers();

        outputView.lastWeekBonus();

//        List<Integer> lottoNumbers = numbers.lottoNumbers;
//        lottoCreator.buyLottos(lottoCount,lottoNumbers);
//        lottoCreator.shuffleLottoNumbers();
//        lotto.getLottos(lottoCount);
//
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        scanner.nextLine();
//        String[] lastNumbers = scanner.nextLine().replaceAll(" ", "").split(",");
//        lotto.lastWeekNumber(lastNumbers);
//
//        System.out.println("보너스 번호를 입력해 주세요.");
//        int bonusNumber = scanner.nextInt();
//
//        System.out.println("당첨 통계");
//        System.out.println("---------------");
    }
}
