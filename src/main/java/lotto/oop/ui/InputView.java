package lotto.oop.ui;

import lotto.oop.domain.LottoNo;
import lotto.oop.domain.LottoNumber;
import lotto.oop.domain.WinNumber;

import java.util.*;

public class InputView {
    public static final String COMMA = ",";
    private Amount amount;
    private Count autoCount;
    private Count handCount;

    private List<LottoNumber> handOperationLotto;
    private WinNumber winNumberInfo;

    public void purchaseInfo() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner sc = new Scanner(System.in);
        amount = new Amount(sc.nextInt());
        System.out.println();
        handOperatioinInfo();
        int autoLottoCount = amount.substract(handCount);
        autoCount = new Count(autoLottoCount);
        System.out.println("수동으로 " + handCount.getLottoCount() + "개, 자동으로 " + autoCount.getLottoCount() + "개를 구매했습니다.");
    }

    private void handOperatioinInfo() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        handCount = new Count(sc.nextInt());
        sc.nextLine();
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> handInputList = new ArrayList<>();
        for(int i = 0; i < handCount.getLottoCount(); i++) {
            String handLotto = sc.nextLine();
            handInputList.add(handLotto);
        }
        convertLotto(handInputList);
        System.out.println();
    }

    private void convertLotto(List<String> handInputList) {
        handOperationLotto = new ArrayList<>();
        for(String number : handInputList) {
            LottoNumber lotto = new LottoNumber(number);
            handOperationLotto.add(lotto);
        }
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
        LottoNumber winLotto = new LottoNumber(numbers);
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = sc.nextLine();
        winNumberInfo = new WinNumber(winLotto, new LottoNo(Integer.parseInt(bonusBall)));
        System.out.println();
    }

    public int getAutoCount() { return autoCount.getLottoCount();}

    public List<LottoNumber> getHandOperationLotto() {
        return handOperationLotto;
    }

    public WinNumber getWinNumberInfo() {
        return winNumberInfo;
    }

}