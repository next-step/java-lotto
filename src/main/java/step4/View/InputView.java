package step4.View;

import step4.LottoGenerator;
import step4.VO.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getResultNumber(){
        return getAnswer("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static String getBonusNumber(){
        return getAnswer("보너스 볼을 입력해 주세요.");
    }

    public static List<LottoNumber> getManualLottoNumbers(){
        String manualLottoNumbersString = scanner.nextLine();
        List<LottoNumber> numberList = new ArrayList<>();
        String[] numbersStringList = manualLottoNumbersString.split(", ");

        validate(numbersStringList);
        for (String numberString: numbersStringList) {
            numberList.add(new LottoNumber(Integer.parseInt(numberString)));
        }
        return numberList;
    }

    private static void validate(String[] numbersStringList) {
        if (numbersStringList.length < LottoGenerator.lottoSize) {
            throw new IllegalArgumentException("수동 로또가 정확히 입력되지 않았습니다.");
        }
    }

    public static int getMoney(){
        return Integer.parseInt(getAnswer("구입금액을 입력해 주세요"));
    }

    public static int getManualLotto(){
        return Integer.parseInt(getAnswer("수동으로 구매할 로또 수를 입력해 주세요."));
    }


    private static String getAnswer(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
