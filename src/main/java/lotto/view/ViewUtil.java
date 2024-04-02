package lotto.view;

import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.InputView.insertNumber;

public class ViewUtil {

    public static Cash insertCash(){
        System.out.println("구입금액을 입력해 주세요.");
        return generateCash();
    }

    public static List<LottoNumber> insertLatestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return generateNumbers();
    }

    public static int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return insertNumber();
    }

    public static ManualLottoCount insertManualLottoCount(Cash cash){
        System.out.println("");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        ManualLottoCount manualLottoCount = new ManualLottoCount(insertNumber());
        manualLottoCount.validateIfLargerThanWholeCount(cash);
        return manualLottoCount;
    }

    public static Lottos generateManualLottos(ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Lottos newLottos = new Lottos();
        Integer iter = 0;
        while(manualLottoCount.isLargerThan(iter)){
            Lotto lotto = new Lotto(generateNumbers());
            newLottos.add(lotto);
            iter++;
        }
        return newLottos;
    }
}
