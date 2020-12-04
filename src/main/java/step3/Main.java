package step3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = settingLottos(money, lottoGenerator);

        String resultString = InputView.getResultNumber();

        checkResult(lottos, resultString);
        // 결과 출력
        ResultView.printResult(lottos, money);
    }

    public static void checkResult(Lottos lottos, String resultString){
        List<LottoNumber> ResultNumberList = getResultNumberList(resultString);
        // 로또 결과 확인
        lottos.checkResult(ResultNumberList);
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
