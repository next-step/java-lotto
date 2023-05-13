/*
 * AuttoLotto.java
 *
 * version 1.0
 *
 * 2023/05/01
 *
 * This software is the confidential and proprietary information of Nayoung Kim
 */

package step2;

import java.util.*;

public class AutoLotto {

    private static final int LOTTO_PRICE = 1000;

    private static final int LOTTO_NUMBER = 6;

    private static final int LOTTO_MAX_VALUE = 45;

    public boolean isMoneyZero(int money){
        if(money == 0) {
            return true;
        }

        return false;
    }

    public boolean validateMoney(int money){
        if(money%LOTTO_PRICE != 0) {
            return false;
        }

        return true;
    }

    public int calculateLottoCnt(int money){
        return money/LOTTO_PRICE;
    }

    // TODO ... 단위테스트를 만들어야 한다.
    public ArrayList<String> makeLottos(int cnt){
        ArrayList<String> lottos = new ArrayList<String>();

        for(int i=0;i<cnt;i++){
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private String makeLotto(){
        int[] lottoNum = new int[LOTTO_NUMBER];
        Random random = new Random();

        for(int i=0;i<lottoNum.length;i++){
            int num = random.nextInt(LOTTO_MAX_VALUE);
            lottoNum[i] = num;
        }

        return Arrays.toString(lottoNum);
    }

    public String sortLotto(String lotto){
        String[] lottoNums = lotto.split(",");
        int[] lottoNumInt = Arrays.asList(lottoNums).stream().mapToInt(Integer::parseInt).toArray();
        Arrays.sort(lottoNumInt); // String array로 sort 하려니깐 제대로 sorting이 되지 않네.... int array이어야 제대로 인지가 된다.

        return returnSortedLotto(lottoNumInt);
    }

    private String returnSortedLotto(int[] lottoNumInt){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<lottoNumInt.length;i++){
            sb.append(lottoNumInt[i]).append(", ");
        }

        return sb.substring(0, sb.length()-2);
    }

    public boolean validateWinningNumbers(String winningNumber){
        if(winningNumber.split(",").length != LOTTO_NUMBER) {
            return false;
        }

        return true;
    }

    // 로또 1장에 특정 숫자가 있는지 비교
    /*
       lotto.indexOf(winningNum)
       lotto.contains(winningNum)
       -> 어느 것이 더 나은가?
     */
    public int compareWinningNumberWithLotto(int winningNum, String lotto, int matchingCnt){
        String[] lottoNums = trimLottoArray(lotto);
        int[] lottoNumInt = Arrays.asList(lottoNums).stream().mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<lottoNumInt.length;i++){
            matchingCnt = validateWinningNumber(matchingCnt, winningNum, lottoNumInt[i]);
        }

        return matchingCnt;
    }

    private String[] trimLottoArray(String lotto){
        String[] lottoNums = lotto.split(",");
        for(int i=0;i<lottoNums.length;i++){
            lottoNums[i] = lottoNums[i].trim();
        }

        return lottoNums;
    }

    private int validateWinningNumber(int matchingCnt, int winningNum, int lottoNum){
        if(winningNum ==lottoNum){
            return ++matchingCnt;
        }

        return matchingCnt;
    }

    public int compareAnswerAtOneLotto(String answer, String lotto){
        int matchingCnt = 0;

        String[] arr = answer.split(",");
        for(int i=0;i<arr.length;i++){
            int oneAnswer = Integer.parseInt(arr[i]);
            matchingCnt = compareWinningNumberWithLotto(oneAnswer, lotto, matchingCnt);
        }

        return matchingCnt;
    }

    public int[] compareAllLotto(String answer, ArrayList<String> lottos){
        int[] result = new int[lottos.size()];
        for(int i=0;i<lottos.size();i++){
            result[i] = compareAnswerAtOneLotto(answer, lottos.get(i));
        }

        return result;
    }

    public String calculateEarningRate(int lottoCnt, double totalMoney){
        double earningRate = (totalMoney/(lottoCnt*LOTTO_PRICE));
        return String.valueOf(Math.floor(earningRate*100)/100.0);
    }
}
