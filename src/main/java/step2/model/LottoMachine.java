package step2.model;

import step2.enums.ExceptionMessage;
import step2.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000; //로또 가격
    private static final int LOTTO_NUMBER = 6; //로또 번호 수

    //로또 구매
    public Lotto buyLotto(int money) {
        int num = receiveMoney(money);
        return getLotto(num);
    }

    //로또 장수 가져오기
    public int receiveMoney(int money) {
        checkMoney(money);
        return money / LOTTO_PRICE;
    }

    //로또 가져오기
    public Lotto getLotto(int num) {
        checkMinus(num);
        Lotto lotto = new Lotto();
        for (int i = 0; i < num; i++) {
            lotto.addLotto(outputLotto());
        }
        return lotto;
    }

    //로또 1장 가져오기
    public List<Integer> outputLotto() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            lotto.add(getLottoNum(lotto));
        }
        Collections.sort(lotto);
        return lotto;
    }

    //로또 랜덤 번호 가져오기
    private int getLottoNum(List<Integer> lotto) {
        int randomNum;
        do {
            randomNum = RandomUtil.randomNum();
        } while (lotto.contains(randomNum));
        return randomNum;
    }

    //1이하 번호가 있을 시 예외발생
    private void checkMinus(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(ExceptionMessage.MINIMUM_LOTTO_NUM.message());
        }
    }

    //돈이 1000원 미만이면 로또구매 X 예외발생
    private void checkMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.MINIMUM_LOTTO_PRICE.message());
        }
    }
}
