package lotto.view;

import java.util.*;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public int inputDataMoney() {
        System.out.println("구입금액을 입력해 주세요.(1,000원 단위)");
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Set<Integer> inputManualLottoNumber() {
        sc = new Scanner(System.in);
        return changedIntegerList(sc.nextLine().split(","));
    }

    public void printGuideInputManualLotto(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    private Set<Integer> changedIntegerList(String[] inputNumbers) {
        Set<Integer> changedList = new HashSet<>();
        for (String numberText : inputNumbers) {
            changedList.add(Integer.parseInt(numberText));
        }
        return changedList;

    }


    public List<Integer> inputDataWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        sc = new Scanner(System.in);
        String[] inputNumbers = sc.nextLine().split(",");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length; i++) {
            int num = Integer.parseInt(inputNumbers[i]);
            numbers.add(num);
        }
        return numbers;
    }

    public int inputBonusNumber() {
        System.out.println("Bonus 번호를 입력해주세요");
        sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
