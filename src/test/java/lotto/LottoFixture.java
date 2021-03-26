package lotto;

import org.assertj.core.util.Lists;

public class LottoFixture {
    public static final Lotto WINNING_NUMBER = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));

    public static final Lotto NONE_MATCHED = new Lotto(Lists.newArrayList(11, 12, 13, 14, 15, 16));
    public static final Lotto ONE_MATCHED = new Lotto(Lists.newArrayList(1, 12, 13, 14, 15, 16));
    public static final Lotto TWO_MATCHED = new Lotto(Lists.newArrayList(1, 2, 13, 14, 15, 16));
    public static final Lotto THREE_MATCHED = new Lotto(Lists.newArrayList(1, 2, 3, 14, 15, 16));
    public static final Lotto FOUR_MATCHED = new Lotto(Lists.newArrayList(1, 2, 3, 4, 15, 16));
    public static final Lotto FIVE_MATCHED = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 16));
    public static final Lotto ALL_MATCHED = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));

}
