package lotto.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.game.Lotto;
import lotto.domain.game.LottoCount;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.Lottos;
import lotto.domain.statistics.LottoResult;
import lotto.domain.statistics.LottoResults;
import lotto.domain.statistics.LottoStatistics;

public final class LottoView {

    private final Scanner scanner = new Scanner(System.in);

    public int readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        int money;
        try {
            money = scanner.nextInt();
            scanner.nextLine();
        } catch (NoSuchElementException ignore) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
        return money;
    }

    public int readLottoManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count;
        try {
            count = scanner.nextInt();
            scanner.nextLine();
        } catch (NoSuchElementException ignore) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
        return count;
    }

    public List<String> readLottoManualNumbers(LottoCount lottoCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoManuals = new ArrayList<>();
        for (int i = 0; i < lottoCount.getManualCount(); i++) {
            lottoManuals.add(validateBlank(scanner.nextLine()));
        }
        return lottoManuals;
    }

    public String readWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return validateBlank(scanner.nextLine().trim());
    }

    public int readBonusBall() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall;
        try {
            bonusBall = scanner.nextInt();
            scanner.nextLine();
        } catch (NoSuchElementException ignore) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
        scanner.close();
        return bonusBall;
    }


    private String validateBlank(final String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
        return text;
    }

    public void printLottoCount(final LottoCount lottoCount) {
        System.out.println();
        System.out.println(MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.",
            lottoCount.getManualCount(),
            lottoCount.getAutoCount()));
    }

    public void printLottos(final Lottos lottos) {
        lottos.getLottos().stream()
            .map(this::lottoMessage)
            .forEach(System.out::println);
    }

    private String lottoMessage(final Lotto lotto) {
        return "[ " + lotto.getLotto().stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(", ")) + " ]";
    }

    public void printLottoResult(final LottoResults lottoResults) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoResults.getLottoResults().stream()
            .map(this::resultMessage)
            .forEach(System.out::println);
    }

    private String resultMessage(final LottoResult lottoResult) {
        return MessageFormat.format("{0}개 일치{1} ({2}원) - {3}개",
            lottoResult.getMatchCount(),
            lottoResult.getMessage(),
            lottoResult.getPrize(),
            lottoResult.getPrizeCount()
        );
    }

    public void printProfitRate(final LottoStatistics lottoStatistics) {
        System.out.println("총 수익률은" + lottoStatistics.getProfitRate() + "입니다.");
    }

}
