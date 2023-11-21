package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.PurchaseQuantity;
import lotto.domain.strategy.LottoGeneration;
import lotto.domain.strategy.ManualLottoGeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView(){}
    public static long inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return  checkNumber(SCANNER.nextLine());
    }
    public static int inputManualCount(){
        System.out.printf("%n수동으로 구매할 로또 수를 입력해 주세요.%n");
        return checkNumber(SCANNER.nextLine());
    }

    public static List<LottoGeneration> inputManualList(PurchaseQuantity purchaseQuantity){
        List<LottoGeneration> result = new ArrayList<>();
        if(purchaseQuantity.find()==0) return result;

        System.out.printf("%n수동으로 구매할 번호를 입력해 주세요.%n");

        for(int i=0;i<purchaseQuantity.find();i++){
            result.add(generateManualLotto());
        }
        return result;
    }

    public static LottoGeneration inputWinLotto(){
        System.out.printf("%n지난 주 당첨 번호를 입력해 주세요.%n");
        return generateManualLotto();
    }

    public static LottoNumber inputBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(checkNumber(SCANNER.nextLine()));
    }


    private static List<Integer> makeIntegarList(String[] array){
        List<Integer> list = new ArrayList<>();

        for(String s : array){
            list.add(checkNumber(s));
        }
        return list;
    }

    private static String[] split(String value){
        return value.replaceAll(" ","").split(",");
    }

    private static int checkNumber(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException error){
            throw new NumberFormatException("숫자만 입력해주세요");
        }
    }

    private static LottoGeneration generateManualLotto(){
        return new ManualLottoGeneration(makeIntegarList(split(SCANNER.nextLine())));
    }


}
