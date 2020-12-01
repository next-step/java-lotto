package step2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int money = InputView.getMoney();

        Generator lottoGenerator = new LottoGenerator();
        lottoGenerator.setNumber("");

        Lottos lottos = new Lottos(money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());

        ResultView.printLottoList(lottos);

        String resultString = InputView.getResultNumber();
        List<Integer> ResultNumberList = getResultNumberList(resultString);
        // 로또 결과 확인
        lottos.checkResult(ResultNumberList);

        // 결과 입력
        Statistic.recordResult(lottos);
        // 결과 출력
        ResultView.printResult(lottos, money);
    }

    public static List<Integer> getResultNumberList(String resultString) {
        List<Integer> numberList = new ArrayList<>();

        for (String number : resultString.split(", ")) {
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }
}
