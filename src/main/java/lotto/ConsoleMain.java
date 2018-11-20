package lotto;

import lotto.config.AutoLottoGeneratorImpl;
import lotto.config.ManualLottoGeneratorImpl;
import lotto.dao.LottosGenerator;
import lotto.dto.Lotto;
import lotto.dto.Money;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.service.LottoGame;
import lotto.service.LottoResult;
import lotto.utils.LottoMaker;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class ConsoleMain {

    public static void main(String[] args){

        //수동 및 자동 게임 세팅
        Money autoMoney = InputView.inputMoney2();
        LottoGame autoGame = new LottoGame(autoMoney,new AutoLottoGeneratorImpl());
        LottoGame manualGame = new LottoGame(autoMoney,new ManualLottoGeneratorImpl(InputView.manualgame()));

        //수동 및 자동 게임 통합
        LottoGame lottoGameTogether = new LottoGame(autoGame.getGamePlays(),manualGame.getGamePlays());

        //수동 및 자동 게임 출력
        ResultView.printAutoAndManual(autoGame.getGames(),manualGame.getGames());
        InputView.printLottoList(lottoGameTogether.getGamePlays());

        //우승번호 및 보너스 번호 받기
        String inputWinnerNumsToString = InputView.winningNumbers();
        int bonusNum = InputView.bonusNum();

        //결과 계산
        Map<Rank,Integer> maps = lottoGameTogether.match(new WinningLotto(LottoMaker.of(inputWinnerNumsToString),bonusNum));
        ResultView.printMatchingResult(maps);

        //결과 출력
        LottoResult lottoResult = new LottoResult( autoMoney.getMoney() , maps);
        ResultView.printProfitResult(lottoResult);


    }
}
