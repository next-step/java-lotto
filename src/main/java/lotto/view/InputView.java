package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Integer> inputLastWeeksCollectNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lastWeeksCollectNumbers = scanner.nextLine();
        return getLottoNumbers(lastWeeksCollectNumbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputPassiveLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<List<Integer>> inputPassiveLottoNumbers(int passiveLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> numbersCollection = new ArrayList<>();
        for (int index = 0; index < passiveLottoCount; index++) {
            Scanner scanner = new Scanner(System.in);
            String numbersString = scanner.nextLine();
            numbersCollection.add(getLottoNumbers(numbersString));
        }
        return numbersCollection;
    }

    private List<Integer> getLottoNumbers(String numbersString) {
        String[] split = numbersString.split(", ");
        return Arrays
                .stream(split)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}