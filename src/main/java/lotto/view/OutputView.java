package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.constant.Rank;
import lotto.dto.LottoRankDto;
import lotto.dto.MatchRankDto;

import java.util.List;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String DASH = " - ";
    private static final String SPACE = " ";

    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String WINNING_RESULT = "당첨 통계";
    private static final String WINNING_RESULT_LINE = "---------";
    private static final String WINNING_MATCH_COUNT = "개 일치";
    private static final String KR_WON = "원";
    private static final String COUNT = "개";

    private static final String PURCHASE_AMOUNT_MESSAGE = "구매 금액을 입력해주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";

    public static void printPurchaseLotto(int amount) {
        stringBuilder.append(amount)
                .append(PURCHASE_COUNT_MESSAGE)
                .append(LINE_BREAK);

        System.out.println(stringBuilder);
        initStringBuilder();
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            stringBuilder.append(LEFT_BRACKET);
            stringBuilder.append(lottoNumbers.toString());
            stringBuilder.append(RIGHT_BRACKET);
            System.out.println(stringBuilder);
            initStringBuilder();
        }
    }

    public static void printWinningResult(MatchRankDto matchRankDto) {
        resultMessage();
        printMatchResult(matchRankDto);
        printBenefitRate(matchRankDto.getBenefitRate());
    }

    private static void resultMessage() {
        stringBuilder.append(WINNING_RESULT);
        stringBuilder.append(LINE_BREAK);
        stringBuilder.append(WINNING_RESULT_LINE);
        System.out.println(stringBuilder);
        initStringBuilder();
    }

    private static void printMatchResult(MatchRankDto matchRankDto) {
        for (LottoRankDto lottoRankDto : matchRankDto.getLottoRankDtos()) {
            stringBuilder.append(makeMatchAndPrizeText(lottoRankDto))
                    .append(LEFT_PARENTHESIS)
                    .append(lottoRankDto.getRank().getPrizeMoney())
                    .append(KR_WON)
                    .append(RIGHT_PARENTHESIS)
                    .append(DASH)
                    .append(lottoRankDto.getCount())
                    .append(COUNT);
            System.out.println(stringBuilder);
            initStringBuilder();
        }
    }

    private static String makeMatchAndPrizeText(LottoRankDto lottoRankDto) {
        StringBuilder stringBuilder = new StringBuilder();
        if (lottoRankDto.getRank() == Rank.SECOND) {
            return stringBuilder.append(lottoRankDto.getRank().getCorrespondCount())
                    .append(WINNING_MATCH_COUNT)
                    .append(", 보너스 볼 일치")
                    .toString();
        }

        return stringBuilder.append(lottoRankDto.getRank().getCorrespondCount())
                .append(WINNING_MATCH_COUNT)
                .append(SPACE)
                .toString();
    }

    private static void printBenefitRate(double benefitRate) {
        final String TOTAL_BENEFIT_RATE_MESSAGE
                = String.format("총 수익률은 %.2f입니다. (기준이 1이기 때문 결과적으로 손해라는 의미임)", benefitRate);
        stringBuilder.append(TOTAL_BENEFIT_RATE_MESSAGE);
        System.out.println(stringBuilder);
        initStringBuilder();
    }

    private static void initStringBuilder() {
        stringBuilder.setLength(0);
    }

    public static void printInputBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);
    }

    public static void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    public static void printManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT);
    }
}
