package step3.model;

import step3.util.RandomUtil;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    private final static String MINIMUM_LOTTO_NUM = "로또는 최소 1장이상부터 생성이 가능합니다.";
    private final static String MINIMUM_LOTTO_PRICE = "로또의 가격은 1000원입니다.";

    private static final int LOTTO_PRICE = 1000; //로또 가격
    private static final int LOTTO_NUMBER = 6; //로또 번호 수

    //로또 구매
    public Lotto buyLotto(int money) {
        return getLotto(receiveMoney(money));
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
    public Set<Integer> outputLotto() {
        Set<Integer> lotto = new HashSet<>();

        while (lotto.size() < LOTTO_NUMBER) {
            lotto.add(getLottoNum());  // 중복된 값은 자동으로 제외
        }

        return lotto.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    //로또 랜덤 번호 가져오기
    private int getLottoNum() {
        return RandomUtil.randomNum();
    }

    //1이하 번호가 있을 시 예외발생
    private void checkMinus(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_NUM);
        }
    }

    //돈이 1000원 미만이면 로또구매 X 예외발생
    private void checkMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_PRICE);
        }
    }

}
