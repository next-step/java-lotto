package lottogame.console;

import lottogame.controller.spi.LottoInputer;
import lottogame.service.request.LottoPurchaseRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleLottoInputer implements LottoInputer {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public LottoPurchaseRequest inputLottoPurchaseRequest() {
        int money = inputMoney();
        int manualLottoCount = inputManualLottoCount();
        List<Set<Integer>> lottoNumbers = inputLottoNumbers(manualLottoCount);
        return new LottoPurchaseRequest(money, manualLottoCount, lottoNumbers);
    }

    private int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private List<Set<Integer>> inputLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> stringToSet(scanner.nextLine()))
                .collect(Collectors.toList());
    }

    private Set<Integer> stringToSet(String input) {
        return Arrays.stream(input.split(","))
                .map(string -> Integer.valueOf(string.strip()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return stringToSet(scanner.nextLine());
    }

    @Override
    public Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
