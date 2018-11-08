package view;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_CHOICE_CNT = 6;
    private static final String COMMA = ",";

    public static int setLottoPayment(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc =  new Scanner(System.in);
        return sc.nextInt();
    }

    public static List<Lotto> buyLottoCount(int price){
        int lottoCount = price/LOTTO_PRICE;
        System.out.println(String.format("%s개를 구매했습니다.", lottoCount));
        return  makeLottoPerCnt(lottoCount);
    }

    public static List<Lotto> makeLottoPerCnt(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i < lottoCount; i++){
            Lotto lotto = new Lotto(LOTTO_CHOICE_CNT);
            lottos.add(lotto);
            lotto.printLotto();
        }
        return lottos;
    }

    public static Lotto lastLottoNumber(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(lastLotto(strSetting(sc.nextLine())));
    }

    public static String[] strSetting(String strLottoNum){
        String[] str = strLottoNum.split(COMMA);
        return str;
    }

    public static List<Integer> lastLotto(String[] lottoNums){
        List<Integer> lastLottoNumbers = new ArrayList<>();
        for(int i =0; i < lottoNums.length; i++){
            if(lottoNums[i] == null){
                throw new NullPointerException();
            }
            lastLottoNumbers.add(Integer.parseInt(lottoNums[i].trim()));
        }
        return lastLottoNumbers;
    }

}
