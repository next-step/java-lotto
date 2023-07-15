package lottogame.console;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.console.util.LocalScanner;
import lottogame.controller.spi.Inputer;

public class ConsoleInputer implements Inputer {

    @Override
    public BigInteger inputMoney() {
        LocalScanner localScanner = LocalScanner.getInstance();
        System.out.println("구입금액을 입력해 주세요.");
        return new BigInteger(localScanner.next());
    }

    @Override
    public int inputPassiveLottoTicketCount() {
        LocalScanner localScanner = LocalScanner.getInstance();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return localScanner.nextInt();
    }

    @Override
    public List<Set<Integer>> inputPassiveLottoTickets(int count) {
        LocalScanner localScanner = LocalScanner.getInstance();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> response = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            response.add(Arrays.stream(localScanner.nextLine().split(","))
                .map(string -> Integer.valueOf(string.strip()))
                .collect(Collectors.toSet()));
        }
        return response;
    }

    @Override
    public Set<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(LocalScanner.getInstance().nextLine().split(","))
            .map(string -> Integer.valueOf(string.strip()))
            .collect(Collectors.toSet());
    }

    @Override
    public Integer inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LocalScanner.getInstance().nextInt();
    }

}
