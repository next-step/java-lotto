package lotto.view;

import lotto.domain.LottoNumbersWrapper;

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

    public LottoNumbersWrapper inputLastWeeksCollectNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
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
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<LottoNumbersWrapper> inputPassiveLottoNumbers(int passiveLottoCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해주세요.");
        List<LottoNumbersWrapper> numbersCollection = new ArrayList<>();
        for (int index = 0; index < passiveLottoCount; index++) {
            Scanner scanner = new Scanner(System.in);
            String numbersString = scanner.nextLine();
            numbersCollection.add(getLottoNumbers(numbersString));
        }
        return numbersCollection;
    }

    private LottoNumbersWrapper getLottoNumbers(String numbersString) {
        String[] split = numbersString.split(", ");
        List<Integer> collect = Arrays
                .stream(split)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return new LottoNumbersWrapper(collect);
    }
}