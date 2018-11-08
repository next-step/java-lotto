package view;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_CHOICE_CNT = 6;
    private static final String COMMA = ",";

    public static int lottoCount = 0;

    public static int setLottoPayment(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc =  new Scanner(System.in);
        return sc.nextInt();
    }

    public static List<Lotto> buyLottoCount(int price){
        List<Lotto> lottos = new ArrayList<>();
        if(price >= LOTTO_PRICE){
            lottoCount = price/LOTTO_PRICE;
            System.out.println(String.format("%s개를 구매했습니다.", lottoCount));

            for(int i =0; i < lottoCount; i++){
                lottos.add(new Lotto(LOTTO_CHOICE_CNT));
            }

            for(int i =0; i < lottoCount; i++){
                System.out.println(lottos.get(i).getNumbers());
            }
        }
        return lottos;
    }


    public static Lotto lastLottoNumberList(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String strLottoNum = sc.nextLine();
//        String strLottoNum = "1, 32, 33, 23, 53, 21";
        String[] lottoNums = strLottoNum.split(COMMA);

        List<Integer> lastLottoNumbers = new ArrayList<>();
        for(int i =0; i < lottoNums.length; i++){
            if(lottoNums[i] == null){
                throw new NullPointerException();
            }
            lastLottoNumbers.add(Integer.parseInt(lottoNums[i].trim()));
        }

        return new Lotto(lastLottoNumbers);
    }


}
