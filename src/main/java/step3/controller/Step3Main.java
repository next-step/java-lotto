package step3.controller;


import cmm.util.InputUtil;
import step3.domain.*;
import step3.view.PrintResult;

import java.util.List;

public class Step3Main {
    public static void main(String[] args) {
        int price = InputUtil.returnInteger("구입금액을 입력해 주세요.");

        LottoFactory makeLotto = new LottoFactory(price);
        PrintResult.printBuyQuantity(makeLotto.buyQuantity());

        List<Lotto> lottoList = makeLotto.makeLottoRandomList();
        PrintResult.printLottoList(lottoList);

        String winningNumbers = InputUtil.returnString("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLottoNumber = makeLotto.makeLottoWithString(winningNumbers);

        int bonusBallNumber = InputUtil.returnInteger("보너스 볼을 입력해 주세요.");

        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, new LottoNumber(bonusBallNumber));
        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLotto);
        WinningJudgement winneingJudgement = new WinningJudgement(winningLotto);

        PrintResult.printLottoMap(winneingJudgement.makeWinningMap(lottoList));
        PrintResult.printResult(winningStatistics.getWinningStatic(), winningStatistics.isBenefit());

    }
}
