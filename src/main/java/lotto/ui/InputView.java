package lotto.ui;

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
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return checkNumber(SCANNER.nextLine());
    }

    public static List<LottoGeneration> inputManualList(PurchaseQuantity purchaseQuantity){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoGeneration> result = new ArrayList<>();
        for(int i=0;i<purchaseQuantity.find();i++){
            result.add(new ManualLottoGeneration(makeIntegarList(split(SCANNER.nextLine()))));
        }
        return result;
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


}
