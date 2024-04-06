package lotto.ui;

import lotto.domain.AnswerSheet;
import lotto.domain.LottoList;
import lotto.match.LottoPrizeCount;
import lotto.match.LottoResult;
import lotto.prize.StandardPrizeRate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.ui.LottoService.LOTTO_VALUE;

public class LottoShop {
    private final LottoController lottoController;
    private final Scanner scanner = new Scanner(System.in);

    public LottoShop(LottoController lottoController) {
        this.lottoController = lottoController;
    }


    public void enter() {
        String inputMoney = inputMoney();

        String passiveLottoCount = buyPassiveLotto();
        List<String> lottoNumbers = inputPassiveLotto(Integer.parseInt(passiveLottoCount));
        LottoList lottoList = lottoController.buyLotto(inputMoney, passiveLottoCount, lottoNumbers);
        printLottoList(passiveLottoCount, lottoList);

        AnswerSheet answerSheet = lottoController.createAnswerSheet(inputAnswerSheet(), inputBonusNumber());
        LottoResult result = lottoController.getResult(lottoList, answerSheet);
        printResult(result);

    }

    private void printLottoList(String passiveLottoCount, LottoList lottoList) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구입했습니다.\n", passiveLottoCount, lottoList.size() - Integer.parseInt(passiveLottoCount));
        lottoList.getLottoTextList().forEach(System.out::println);
    }


    public String inputMoney() {
        System.out.println("구매 금액을 입력하세요");
        return scanner.nextLine();
    }

    public String inputAnswerSheet() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return scanner.nextLine();
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n------");
        lottoResult.getStatistics().forEach(this::printLottoStatistics);
        System.out.printf("총 수익률은 %.2f 입니다.\n", lottoResult.getWinningPercent(new StandardPrizeRate(), LOTTO_VALUE));
    }

    private void printLottoStatistics(LottoPrizeCount lotto) {
        String bonusWord = lotto.hasBonus() ? ", 보너스 볼 일치" : "";
        System.out.printf("%d개 일치%s (%s원)- %d개\n", lotto.getCorrectNumber(), bonusWord, lotto.getPrize(), lotto.getCount());
    }

    public String buyPassiveLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return scanner.nextLine();
    }

    public List<String> inputPassiveLotto(int buyPassiveCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        List<String> lottoText = new ArrayList<>();
        for (int i = 0; i < buyPassiveCount; i++) {
            lottoText.add(scanner.nextLine());
        }
        return lottoText;
    }
}
