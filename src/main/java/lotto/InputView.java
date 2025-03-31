package lotto;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class InputView {

    private final Scanner reader = new Scanner(in);

    public int receiveMoney() {
        out.println("구매금액을 입력해 주세요.");
        return reader.nextInt();
    }

    public void printBoughtLottos(Lotto[] lottos) {
        out.println(lottos.length + "개를 구매했습니다.");
        Arrays.stream(lottos)
                .forEach(this::printLotto);

    }

    private void printLotto(Lotto lotto) {
        out.println(Arrays.toString(lotto.getLottoNumbers()));
    }

    public int[] receiveWinningLottoNumbers() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        reader.nextLine();
        return Arrays.stream(reader.nextLine().split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int receiveBonusNumber() {
        out.println("보너스 볼을 입력해 주세요.");
        return reader.nextInt();
    }
}
