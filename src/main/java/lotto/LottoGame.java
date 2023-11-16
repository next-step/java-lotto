package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    public static final int ZERO = 0;
    public static final int ONE_GAME = 1000;
    public static final int TREE_MATCH = 3;
    public static final int FOUR_MATCH = 4;
    public static final int FIVE_MATCH = 5;
    public static final int SIX_MATCH = 6;
    public static final double RATE_OF_RETURN = 0.0;

    public static List<Lotto> createLottoGames(int gameCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < gameCount; i++){
            lottos.add(new Lotto(sortLottoNumber(createLottoNumber())));
        }
        return lottos;
    }

    public static int countGame(int money){
        return money / ONE_GAME;
    }

    public static List<Integer> createLottoNumber(){
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return numList.subList(0, 6);
    }

    public static List<Integer> convertLastLottoNumbers(String text){
        List<Integer> lastLottoNumbers = new ArrayList<>();
        String[] values = splitText(clearValue(text));
        for(String str : values){
            lastLottoNumbers.add(convertNum(str));
        }
        checkLottoNumberCount(lastLottoNumbers);
        return lastLottoNumbers;
    }

    private static void checkLottoNumberCount(List<Integer> lastLottoNumbers) {
        if(lastLottoNumbers.size() !=6 ){
            throw new IllegalArgumentException("로또 한개임당 6개 숫자 입니다. 확인후 다시 진행 해주세요");
        }
    }

    public static List<Integer> sortLottoNumber(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    private static String clearValue(String text){
        return text.replaceAll(" ", "");
    }

    private static String[] splitText(String text){
        return text.split(",");
    }

    public static int convertNum(String text) {
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자 변환시 오류 발생 하였습니다. 숫자 List에 숫자가 아닌 값이 존재 합니다.");

        }
    }

    public static LottoResult lottoResult(int money, List<Lotto> lottos, List<Integer> lastLotto){
        List <Integer> lottoMatchResults = new ArrayList<>();

        for(Lotto lotto : lottos){
            lottoMatchResults.add(lotto.matchCount(lastLotto));
        }

        int tree = getCount(lottoMatchResults, TREE_MATCH);
        int four = getCount(lottoMatchResults, FOUR_MATCH);
        int five = getCount(lottoMatchResults, FIVE_MATCH);
        int six = getCount(lottoMatchResults, SIX_MATCH);;

        double rateOfReturn = rate(tree, four, five, six, money);
        LottoResult lottoResult = new LottoResult(tree, four, five, six, rateOfReturn);

        return lottoResult;
    }

    private static double rate(int tree, int four, int five, int six, int money) {
        LottoOperator calc = new LottoOperator();
        double rate = RATE_OF_RETURN;

        rate += calc.calculate(tree, 5000, LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(four, 50000, LottoOperator.Operator.MULTIPLY );
        rate += calc.calculate(five, 1500000, LottoOperator.Operator.MULTIPLY );
        rate += calc.calculate(six, 2000000000, LottoOperator.Operator.MULTIPLY );
        rate = calc.calculate(rate, money, LottoOperator.Operator.MINUS );
        rate = calc.calculate(rate, money, LottoOperator.Operator.DIVIDE );

        return rate;
    }

    private static int getCount(List<Integer> lottoMatchResults, int matchNum) {
        return (int) lottoMatchResults.stream().filter(number -> number == matchNum).count();
    }

}
