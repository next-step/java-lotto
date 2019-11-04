package lotto.view;

public class OutPutView {
    private static final String GAME_COUNT_PRINT_MESSAGE = "%d개를 구매했습니다.";

    public static void printGameCount(int lottoSize) {
        System.out.println(String.format(GAME_COUNT_PRINT_MESSAGE, lottoSize));
    }
}
