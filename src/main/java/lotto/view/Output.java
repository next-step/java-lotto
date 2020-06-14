package lotto.view;

import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class Output {

    public void printBuyLottoNumber(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printResultStatic(Map<Integer, Integer> inputResultStatic) {

        for (Map.Entry<Integer, Integer> gameResult : inputResultStatic.entrySet()) {
            String money = Prize.findByMoney(gameResult.getKey()).getMoney();
            System.out.println(gameResult.getKey() + "개 일치" + money + "-" + gameResult.getValue() + "개");
        }

    }

}
