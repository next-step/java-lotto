package step3.controller;


import cmm.util.InputUtil;
import step3.domain.Lotto;
import step3.domain.LottoFactory;
import step3.domain.LottoNumber;
import step3.domain.WinningStatistics;
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
        Lotto winningLotto = makeLotto.makeLottoWithString(winningNumbers);

        int bonusBallNumber = InputUtil.returnInteger("보너스 볼을 입력해 주세요.");
        LottoNumber bonusBall = new LottoNumber(bonusBallNumber);

        WinningStatistics winningStatistics = new WinningStatistics(lottoList,winningLotto,bonusBall);
        PrintResult.printLottoMap(winningStatistics.makeWinningMap());
        PrintResult.printResult(winningStatistics.getWinningStatic(), winningStatistics.isBenefit());

    }
}
