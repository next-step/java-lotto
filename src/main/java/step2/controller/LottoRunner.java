package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        //UI관련 인스턴스 생성
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        //로또액수 입력
        int numberOfLotto = inputView.enterLottoPrice();

        //로또액수로 로또 실행
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(new RandomGenerator());
        List<LottoNumber> lottoNumbers = lottoVendingMachine.makeLottoNumberWithTimes(numberOfLotto);

        //실행결과 출력
        resultView.printLottoNumbers(lottoNumbers);

        //로또 당첨번호 입력
        LottoNumber winNumber = inputView.enterWinNumber();
        BonusNumber bonusNumber = inputView.enterBonusNumber(winNumber);

        //로또실행값 통계 계산
        Analyst analyst = new Analyst(lottoNumbers, winNumber, bonusNumber);
        CountsByRank countsByRank = analyst.getCountsByRank();
        float revenueRatio = analyst.revenueRatio(countsByRank);

        //로또실행값 통계 출력
        List<Rank> excludePrintRank = List.of(Rank.MISS);
        resultView.printCountByRank(countsByRank, excludePrintRank);
        resultView.printRevenueRatio(revenueRatio);
    }
}
