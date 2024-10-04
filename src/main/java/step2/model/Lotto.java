package step2.model;

import step2.enums.ExceptionMessage;
import step2.util.DoubleUtil;
import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final static int MINIMUM_LOTTO_NUM = 1;
    private final static int MAXIMUM_LOTTO_NUM = 45;

    private final List<List<Integer>> lottos = new ArrayList<>();
    private final PrizeStatics prizeStatics = new PrizeStatics();

    private final int money;

    public Lotto(int money) {
        this.money = money;
    }

    //로또 추가
    public void addLotto(List<Integer> lotto) {
        this.lottos.add(lotto);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    //당첨번호를 받아 로또 당첨 개수를 확인
    public void checkPrizeNum(String prizeNum) {
        String[] prizeLotto = StringUtil.divideNum(prizeNum);
        checkPrizeNum(prizeLotto);
        for (List<Integer> lotto : lottos) {
            prizeStatics.prize(checkLottoNum(lotto, prizeLotto));
        }
    }

    public PrizeStatics getPrizeStatics() {
        return prizeStatics;
    }

    //수익률을 가져온다.
    public double rateOfReturn() {
        return DoubleUtil.twoDecimal((double) prizeStatics.prizeMoney() / money);
    }

    //로또의 동일 숫자 확인
    private int checkLottoNum(List<Integer> lotto, String[] prizeLotto) {
        int matchCount = 0;
        for (String s : prizeLotto) {
            if (lotto.contains(Integer.parseInt(s))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    //입력받은 당첨금액이 로또번호 범위를 벗어나지 않았는지 체크한다.
    private void checkPrizeNum(String[] prizeLotto) {
        for (String num : prizeLotto) {
            checkNum(Integer.parseInt(num));
        }
    }

    //번호가 1~45 범위에 포함되는지 체크한다.
    private void checkNum(int num) {
        if (num < MINIMUM_LOTTO_NUM || num > MAXIMUM_LOTTO_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_LOTTO_NUM.message());
        }
    }
}
