package lotto.view;

import lotto.domain.*;
import lotto.util.LottoViewConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOutputView {

    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_POSTFIX = "]";

    public void printPurchaseAmountGuide() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.stream()
                .map(LottoTicket::lottoNumbers)
                .forEach(this::printLottoNumbers);
        System.out.println();
    }

    private void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        String resultNumbers = lottoNumbers.stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(LottoViewConstants.LOTTO_NUMBERS_DELIMITER));
        System.out.println(LOTTO_NUMBERS_PREFIX + resultNumbers + LOTTO_NUMBERS_POSTFIX);
    }

    public void printWinningNumbersGuide() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
    }

    public void printLottoResult(LottoResult lottoResult) {
        printLottoResultGuide();
        printLottoResultCount(lottoResult);
        printLottoResultEarningRate(lottoResult);
    }

    private void printLottoResultGuide() {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
    }

    private void printLottoResultCount(LottoResult lottoResult) {
        List<LottoPrize> lottoPrizes = new ArrayList<LottoPrize>(Arrays.asList(
                LottoPrize.values()));
        lottoPrizes.remove(LottoPrize.NOTHING);
        lottoPrizes.sort((prize1, prize2) -> (int) (prize1.sameCount() - prize2.sameCount()));
        lottoPrizes.forEach(lottoPrize ->
                System.out.println(eachLottoResultCountSentence(lottoPrize, lottoResult)));
    }

    private String eachLottoResultCountSentence(LottoPrize lottoPrize, LottoResult lottoResult) {
        return lottoPrize.sameCount() +
                "개 일치 (" +
                lottoPrize.prizeMoney() +
                "원) - " +
                lottoResult.lottoPrizeCount(lottoPrize) +
                "개";
    }

    private void printLottoResultEarningRate(LottoResult lottoResult) {
        System.out.println("총 수익률은 " + lottoResult.earningRate() + "입니다.");
    }
}
