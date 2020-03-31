package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicketUtils {
    public static List<Integer> lottoNumberRange = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                    26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));

    public static final int TICKET_PRICE = 1000;
    public static final int TICKET_MIN_NUMBER = 1;
    public static final int TICKET_MAX_NUMBER = 45;
    public static final int RANGE = 6;
}
