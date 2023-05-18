package study;

import java.util.List;

import study.domain.Lottery;
import study.domain.LotteryContainer;
import study.domain.generator.NumberGenerator;
import study.domain.generator.impl.AutoNumberGenerator;
import study.view.LottoInputView;
import study.view.LottoOutputView;

public class StudyMain {
    
    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        inputView.purchase();
        
        NumberGenerator generator = new AutoNumberGenerator();
        LotteryContainer lottoContainer = new LotteryContainer(inputView.getLottoCount(), generator);
        for (Lottery lotto : lottoContainer.getTotalLottery()) {
            System.out.println(lotto.getLottery());
        }
        System.out.println("");

        inputView.inputWinNumber();
        System.out.println("");

        lottoContainer.setWinNumbers(inputView.getWinNumbers());
        lottoContainer.runGame();

        List<Integer> winners = lottoContainer.getWinnerList();

        LottoOutputView outputView = new LottoOutputView(winners, inputView.getAmount());
        outputView.getWinnerStatic();
    }
}
