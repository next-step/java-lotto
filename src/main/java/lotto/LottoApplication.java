package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInputReader;
import lotto.view.ConsoleOutputWriter;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상하지 못한 예외가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public static void run() {
        final LottoMoney lottoMoney = ConsoleInputReader.readLottoMoney();

        final LottoCount lottoCount = ConsoleInputReader.readLottoCount();
        LottoGenerator.checkProperLottoCount(lottoMoney, lottoCount);

        final Lottos manualLottos =
                ConsoleInputReader.readManualLottos(lottoCount.getValue());

        final LottoMoney remainLottoMoney = lottoMoney.pay(lottoCount.toTotalLottoPrice());
        final Lottos autoLottoContents =
                LottoGenerator.generateLottos(remainLottoMoney, new RandomCandidateStrategy());
        ConsoleOutputWriter.printManualAndAutoLottos(manualLottos, autoLottoContents);

        final Lotto lotto = ConsoleInputReader.readWinningLottoValue();
        final LottoNumber bonus = ConsoleInputReader.readLottoNumberValue();
        final LottoGame lottoGame = new LottoGame(manualLottos, autoLottoContents, lotto, bonus);

        final LottoResult lottoResult = lottoGame.result();
        ConsoleOutputWriter.printLottoResultStatistic(lottoResult, lottoMoney);
    }
}
