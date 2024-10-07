package step2.model;

import step2.enums.LottoPrize;
import step2.util.DoubleUtil;
import step2.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoConfirmation {

    private final static String RANGE_LOTTO_NUM = "로또번호는 1~45범위안에 포함되야 합니다.";
    private final static String NOT_MATCH_PRIZE = "로또 당첨번호를 맞춰보지 않았습니다.";

    private final static int MINIMUM_LOTTO_NUM = 1;
    private final static int MAXIMUM_LOTTO_NUM = 45;
    private final static int LOTTO_PRICE = 1000;

    private Map<Integer, Integer> prizes = new HashMap<>();
    private Lotto lotto;

    //당첨번호를 받아 로또 당첨 개수를 확인
    public void checkPrizeNum(Lotto lotto, String prizeNum) {
        this.lotto = lotto;
        resetPrize();
        String[] prizeLotto = StringUtil.divideNum(prizeNum);
        checkPrizeNum(prizeLotto);
        for (List<Integer> lottoNum : lotto.getLottos()) {
            prize(checkLottoNum(lottoNum, prizeLotto));
        }
    }

    //로또당첨
    public void prize(int matchCount) {
        prizes.put(matchCount, prizes.getOrDefault(matchCount, 0) + 1);
    }

    //당첨된 숫자의 로또 개수 가져오기
    public int getPrize(int matchCount) {
        return prizes.getOrDefault(matchCount, 0);
    }

    //수익률을 가져온다.
    public double rateOfReturn() {
        checkPrize();
        return DoubleUtil.twoDecimal((double) prizeMoney() / lottoPrice());
    }

    public Map<Integer, Integer> getPrizes() {
        return prizes;
    }

    //현재 총 당첨금액 가져오기
    private int prizeMoney() {
        checkPrize();
        int prizeMoney = 0;
        for (Map.Entry<Integer, Integer> entry : prizes.entrySet()) {
            prizeMoney += LottoPrize.calculateTotalPrize(entry.getKey(), entry.getValue());
        }
        return prizeMoney;
    }

    private void resetPrize() {
        this.prizes = new HashMap<>();
    }

    private int lottoPrice() {
        return this.lotto.getLottos().size() * LOTTO_PRICE;
    }

    //로또의 동일 숫자 확인
    private int checkLottoNum(List<Integer> lotto, String[] prizeLotto) {
        int matchCount = 0;
        for (String s : prizeLotto) {
            matchCount += lotto.contains(Integer.parseInt(s)) ? 1 : 0;
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
            throw new IllegalArgumentException(RANGE_LOTTO_NUM);
        }
    }

    //로또 당첨번호를 맞춰봤는지 체크한다.
    private void checkPrize() {
        if (prizes.isEmpty()) {
            throw new IllegalArgumentException(NOT_MATCH_PRIZE);
        }
    }
}
