package step3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = settingLottos(money, lottoGenerator);

        ResultNumber.settingLottoResultNumber(InputView.getResultNumber());
        ResultNumber.settingLottoBonusNumber(InputView.getBonusNumber());

        lottos.checkResult();

        // 결과 출력
        ResultView.printResult(money);
    }

    public static Lottos settingLottos(int money, LottoGenerator lottoGenerator) {
        Lottos lottos = new Lottos(money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());

        ResultView.printLottoList(lottos);

        return lottos;
    }

    public static List<LottoNumber> getResultNumberList(String resultString) {
        List<LottoNumber> numberList = new ArrayList<>();

        for (String number : resultString.split(", ")) {
            numberList.add(new LottoNumber(Integer.parseInt(number)));
        }

        return numberList;
    }
}
