package lotto.oop.ui;

import lotto.oop.domain.LottoNumber;
import lotto.oop.domain.WinNumber;

import java.util.*;

public class InputView {
    public static final String COMMA = ",";
    public static final int PIRCE_ONE_LOTTO = 1000;
    private int amount;
    private int autoCount;
    private int handCount;

    private List<LottoNumber> handOperationLotto;
    private WinNumber winNumberInfo;

    public void purchaseInfo() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner sc = new Scanner(System.in);
        this.amount = sc.nextInt();
        this.autoCount = this.amount / PIRCE_ONE_LOTTO;
        System.out.println();
        handOperatioinInfo();
        autoCount -= handCount;
        System.out.println("수동으로 " + handCount + "개, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    private void handOperatioinInfo() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        this.handCount = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> handInputList = new ArrayList<>();
        for(int i = 0; i < handCount; i++) {
            String handLotto = sc.nextLine();
            handInputList.add(handLotto);
        }
        convertLotto(handInputList);
        System.out.println();
    }

    private void convertLotto(List<String> handInputList) {
        handOperationLotto = new ArrayList<>();
        for(String number : handInputList) {
            LottoNumber lotto = new LottoNumber();
            lotto.setGenerateNumbers(convertInt(number));
            handOperationLotto.add(lotto);
        }
    }

    public List<Integer> convertInt(String result) {
        List<Integer> number = new ArrayList<>();
        String[] numberString = result.split(COMMA);
        for (String value : numberString) {
            number.add(Integer.parseInt(value));
        }
        return number;
    }

    public void printLotto(List<LottoNumber> publishLottoList) {
        for (LottoNumber list: publishLottoList) {
            System.out.println(list.getGenerateNumbers());
        }
        System.out.println();
    }

    public void winngNumbersInfo() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        List<Integer> numberList = convertInt(numbers);
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = sc.nextLine();
        winNumberInfo = new WinNumber(numberList, Integer.parseInt(bonusBall));
        System.out.println();
    }

    public int getAutoCount() {
        return autoCount;
    }

    public List<LottoNumber> getHandOperationLotto() {
        return handOperationLotto;
    }

    public WinNumber getWinNumberInfo() {
        return winNumberInfo;
    }

}