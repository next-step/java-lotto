import lotto.domain.LottoStore;
import lotto.domain.Winners;
import lotto.view.SummaryPrinter;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입 금액을 입력 해 주세요.");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        Lottos lottos = lottoStore.sold(price);

        System.out.println(lottos);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();

        Winners winners = lottoStore.getWinner(lottos, winningNumbers.split(","));
        SummaryPrinter.summary(winners);
    }
}