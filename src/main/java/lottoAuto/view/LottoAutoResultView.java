package lottoAuto.view;

import lottoAuto.service.WinningCount;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAutoResultView extends LottoAutoInputView {
    public List<List> showMyLottoInformation() {
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice();

        System.out.println(lottoAutoResultService.showAmount() + "개를 구매했습니다.");
        List<List> myLottoNumber = lottoAutoResultService.showLottoNumber();
        for (int i = 0; i < myLottoNumber.size(); i++) {
            System.out.println(myLottoNumber.get(i));
        }
        return myLottoNumber;
    }

    public List<Integer> showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = inputWinningNumber();
        return winningNumber;
    }

    public int showBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = inputBonusBall();
        return bonusBall;
    }

    public void showWinningStatistic(List<Integer> winning_count,List<Integer> bonus_count) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println(winning_count);
        System.out.println(bonus_count);

        List<WinningCount> winningCounts = new ArrayList<>();
        for(int i=0;i<winning_count.size();i++){
            winningCounts.add(WinningCount.match(winning_count.get(i),bonus_count.get(i)));
        }

        System.out.println(winningCounts);
        for(WinningCount winningCount : winningCounts){
            System.out.println(winningCount.getMessage()+" - ");
        }
    }

}
