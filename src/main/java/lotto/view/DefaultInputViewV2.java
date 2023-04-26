package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DefaultInputViewV2 implements InputViewV2 {
    private final Scanner scanner = new Scanner(System.in);
    public final String SPLIT_REGEX = ",";

    @Override
    public long purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        long purchaseAmount = Long.parseLong(scanner.nextLine());

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1,000원보다 작을 수 없습니다.");
        }

        return purchaseAmount;
    }

    @Override
    public int manualQuantity(long purchaseAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualQuantity = Integer.parseInt(scanner.nextLine());

        if (manualQuantity > purchaseAmount / Lottos.LOTTO_PRICE) {
            String message = String.format(
                    "구매 금액을 초과하였습니다. 최대 %d개 구매가능합니다.",  purchaseAmount / Lottos.LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }

        return manualQuantity;
    }

    @Override
    public List<Lotto> manualNumbers(int manualQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualQuantity; i++) {
            String strNumbers = scanner.nextLine();
            lottos.add(new Lotto(convertNumbers(strNumbers)));
        }

        return lottos;
    }

    @Override
    public List<Integer> lastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String strNumbers = scanner.nextLine();
        return convertNumbers(strNumbers);
    }

    @Override
    public Number bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Number(scanner.nextInt());
    }

    private List<Integer> convertNumbers(String strNumbers) {
        return Arrays.stream(strNumbers.split(SPLIT_REGEX)).map(s -> {
            s = s.trim();
            return Integer.parseInt(s);
        }).collect(Collectors.toList());
    }
}
