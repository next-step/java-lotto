package step2.view;

import step2.dto.WinningInformationDto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_FORMAT = "[%d, %d, %d, %d, %d, %d]";
    private static final String WINNING_STATICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---------";
    private static final String WINNING_STATICS_FORMAT ="%d개 일치 (%d원)- %d개";
    private static final String EARNING_RATE_FORMAT ="총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printNumberOfPurchase(int number) {
        System.out.println(number + NUMBER_OF_PURCHASE);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        String format = String.format(LOTTO_NUMBERS_FORMAT, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));
        System.out.println(format);

    }

    public static void printWinningStatics(List<WinningInformationDto> informationList ) {
        System.out.println(WINNING_STATICS);
        System.out.println(DIVIDING_LINE);
        for (WinningInformationDto information : informationList) {
            String format = String.format(WINNING_STATICS_FORMAT, information.numberOfMatching, information.prizeMoney, information.numberOfLotto);
            System.out.println(format);

        }
        System.out.println();

    }

    public static void earningRate(double rate){
        String format = String.format(EARNING_RATE_FORMAT, rate);
        System.out.println(format);
    }

}
