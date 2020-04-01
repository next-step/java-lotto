package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicketUtils {
    public static List<Integer> lottoNumberRange = new ArrayList<>();

    static {
        for (int i = 1, end = 45; i <= end; i++) {
            lottoNumberRange.add(i);
        }
    }

    public static final int TICKET_PRICE = 1000;
    public static final int TICKET_MIN_NUMBER = 1;
    public static final int TICKET_MAX_NUMBER = 45;
    public static final int RANGE = 6;
}
