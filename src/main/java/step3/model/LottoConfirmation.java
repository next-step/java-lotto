package step3.model;

import step3.enums.LottoPrize;
import step3.util.DoubleUtil;
import step3.util.StringUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoConfirmation {

    private final static String RANGE_LOTTO_NUM_MESSAGE = "로또번호는 1~45범위안에 포함되야 합니다.";
    private final static String NOT_MATCH_PRIZE_MESSAGE = "로또 당첨번호를 맞춰보지 않았습니다.";
    private final static String BONUS_NUM_ALREADY_CONTAIN_MESSAGE = "보너스번호가 이미 당첨번호에 포함되어있습니다.";

    private final static int MATCH_COUNT_WON = 3;
    private final static int BONUS_MATCH_COUNT = 5;

    private final static int MINIMUM_LOTTO_NUM = 1;
    private final static int MAXIMUM_LOTTO_NUM = 45;
    private final static int LOTTO_PRICE = 1000;

    private Map<LottoPrize, Integer> prizes = new HashMap<>();
    private PurchasedLotto purchasedLotto;

    //당첨번호를 받아 로또 당첨 개수를 확인
    public void checkPrizeNum(PurchasedLotto purchasedLotto, String prizeNum, int bonusNum) {
        String[] prizeLotto = StringUtil.divideNum(prizeNum);
        confirmBonusNumAlreadyContainsPrizeNum(prizeLotto, bonusNum);
        this.purchasedLotto = purchasedLotto;
        resetPrize();
        confirmPrizeNumRange(prizeLotto);
        for (Lotto lottoNum : purchasedLotto.getPurchasedLotto()) {
            int matchCount = confirmExistLottoNum(lottoNum, prizeLotto);
            prize(matchCount, confirmBonusLottoCheckWhether(matchCount, lottoNum, bonusNum));
        }
    }

    //로또당첨
    public void prize(int matchCount, boolean bonusMatch) {
        if (matchCount >= MATCH_COUNT_WON) {
            LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, bonusMatch);
            prizes.put(lottoPrize, prizes.getOrDefault(lottoPrize, 0) + 1);
        }
    }

    //당첨된 숫자의 로또 개수 가져오기
    public int getPrize(LottoPrize lottoPrize) {
        return prizes.getOrDefault(lottoPrize, 0);
    }

    //수익률을 가져온다.
    public double rateOfReturn() {
        confirmAlreadyCheckPrizeNum();
        return DoubleUtil.twoDecimal((double) prizeMoney() / lottoPrice());
    }

    public Map<LottoPrize, Integer> getPrizes() {
        return prizes;
    }

    //보너스번호를 확인할지 여부를 체크한다
    private boolean confirmBonusLottoCheckWhether(int matchCount, Lotto lotto, int bonusNum) {
        boolean bonusMatch = false;
        if (matchCount == BONUS_MATCH_COUNT) {
            bonusMatch = lotto.confirmExistLottoNum(bonusNum);
        }
        return bonusMatch;
    }

    //현재 총 당첨금액 가져오기
    private int prizeMoney() {
        confirmAlreadyCheckPrizeNum();
        return prizes.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private void resetPrize() {
        this.prizes = new HashMap<>();
    }

    private int lottoPrice() {
        return this.purchasedLotto.getPurchasedLotto().size() * LOTTO_PRICE;
    }

    //로또의 동일 숫자 확인
    private int confirmExistLottoNum(Lotto lotto, String[] prizeLotto) {
        int matchCount = 0;
        for (String s : prizeLotto) {
            matchCount += lotto.confirmExistLottoNum(Integer.parseInt(s)) ? 1 : 0;
        }
        return matchCount;
    }

    //입력받은 당첨번호가 로또번호 범위를 벗어나지 않았는지 체크한다.
    private void confirmPrizeNumRange(String[] prizeLotto) {
        for (String num : prizeLotto) {
            confirmLottoNumRange(Integer.parseInt(num));
        }
    }

    //번호가 1~45 범위에 포함되는지 체크한다.
    private void confirmLottoNumRange(int num) {
        if (num < MINIMUM_LOTTO_NUM || num > MAXIMUM_LOTTO_NUM) {
            throw new IllegalArgumentException(RANGE_LOTTO_NUM_MESSAGE);
        }
    }

    //로또 당첨번호를 맞춰봤는지 체크한다.
    private void confirmAlreadyCheckPrizeNum() {
        if (prizes.isEmpty()) {
            throw new IllegalArgumentException(NOT_MATCH_PRIZE_MESSAGE);
        }
    }

    //보너스번호가 이미 당첨번호에 포함되어있지는 않은지 체크한다.
    private void confirmBonusNumAlreadyContainsPrizeNum(String[] prizeNum, int bonusNum) {
        if (Arrays.stream(prizeNum).mapToInt(Integer::parseInt).anyMatch(num -> num == bonusNum))
            throw new IllegalArgumentException(BONUS_NUM_ALREADY_CONTAIN_MESSAGE);
    }
}
