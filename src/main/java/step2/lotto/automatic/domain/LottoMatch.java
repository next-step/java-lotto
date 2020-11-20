package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;
import step2.lotto.automatic.view.InputStep2View;
import step2.lotto.automatic.view.OuterStep2View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMatch {

    private static InputStep2View inputStep2View = new InputStep2View();
    private static OuterStep2View outerStep2View = new OuterStep2View();
    private static LottoAutoNumbers lottoAutoNumbers;  // auto 번호 생성
    private static LottoWinningNumber lottoWinningNumber; // 당첨번호 관리

    private static String GOOD_EARNING_RATE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)"; // 좋은 수익률
    private static String NOT_GOOD_EARNING_RATE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";// 나쁜수익률

    private static final int LOTTO_WINNING_PRICE_RANK = 4; //로또 상금 받을 수 있는 등수
    private static final int MAKEAUTONUMBER = 6; // 한게임당 필요한 번호 갯수
    private static final int MAKE_LOTTONUMBER_COUNT = 45; // 로또번호 생성 갯수
    private static final int LOTTO_PRICE = 1000; //로또 가격
    private int lottoPurchaseCount = 0; //로또 구매 갯수

    private List<List<Integer>> autoLottoNumbers = new ArrayList<>(); // 로또 자동구매 리스트
    private List<LottoStatus> lottoStatusList = new ArrayList<>(); //로또 상태리스트

    public LottoMatch(int purchaseAmount) {
        CheckPurchaseAmount(purchaseAmount);
        makeLottoStatusList();

        this.lottoAutoNumbers = new LottoAutoNumbers(MAKE_LOTTONUMBER_COUNT);
        this.lottoPurchaseCount = purchaseAmount / LOTTO_PRICE;
    }

    /**
     * 로또번호 맞추기 시작
     */
    public void run() {
        makeAutoNumberList();

        outerStep2View.printBuyLotto(lottoPurchaseCount);
        outerStep2View.printAutoLottoNumbers(autoLottoNumbers);

        runLottoMatch();

        for (LottoStatus lottoStatus : lottoStatusList) {
            outerStep2View.printLottoResult(lottoStatus);
        }

        double earningRate = calculateEarningRate();

        if (earningRate > 1) {
            outerStep2View.printeEarningRate(earningRate, GOOD_EARNING_RATE);
        }

        if (earningRate <= 1) {
            outerStep2View.printeEarningRate(earningRate, NOT_GOOD_EARNING_RATE);
        }
    }

    /**
     * 로또 번호 맞춰보기
     */
    private void runLottoMatch() {
        lottoWinningNumber = new LottoWinningNumber(inputLottoNumbers());

        for (List<Integer> list : autoLottoNumbers) {
            addWinnerCount(lottoWinningNumber.getRank(list));
        }
    }

    /**
     * 당첨 상태 count하기
     *
     * @param parmaIndex
     */
    private void addWinnerCount(Integer parmaIndex) {
        if (parmaIndex >= 1 && parmaIndex <= 4) {
            lottoStatusList.get(parmaIndex - 1).addLottoWinning();
        }
    }

    /**
     * 자동로또번호 생성
     */
    private void makeAutoNumberList() {
        List<Integer> addList = new ArrayList<>();

        for (int i = lottoPurchaseCount; i > 0; i--) {
            addList = lottoAutoNumbers.getAutoNumbers(MAKEAUTONUMBER);
            Collections.sort(addList);
            this.autoLottoNumbers.add(addList);
        }
    }

    /**
     * 로또 상태 구하기
     * index 0 - 1등
     * index 1 - 2등
     * index 3 - 3등
     * index 4 - 4등
     */
    private void makeLottoStatusList() {
        LottoStatus lottoStatus;

        for (int i = 1; i <= LOTTO_WINNING_PRICE_RANK; i++) {
            lottoStatus = new LottoStatus(i);
            lottoStatusList.add(lottoStatus);
        }
    }

    private void CheckPurchaseAmount(int paramValue) {
        if (paramValue < LOTTO_PRICE) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2AmountCheck());
        }
    }

    private String inputLottoNumbers() {
        System.out.println("지난 주 당첨결과를 입력해주세요");
        String returnValue = inputStep2View.inputWinningLottoNumbers();

        return returnValue;
    }

    /**
     * 고객수익률 구하기
     *
     * @return
     */
    private double calculateEarningRate() {
        int totalEarningRate = 0;
        int purchaseAmount = lottoPurchaseCount * LOTTO_PRICE;
        double returnValue = 0;

        for (int i = 0; i < lottoStatusList.size(); i++) {
            totalEarningRate = totalEarningRate + lottoStatusList.get(i).getCumulativeAmount();
        }
        returnValue = totalEarningRate / purchaseAmount;
        return returnValue;
    }
}
