package lotto;

import java.util.function.Function;

public class LottoGameConstant {

  public static final int MINIMUM_LOTTO_NUMBER = 1;
  public static final int MAXIMUM_LOTTO_NUMBER = 45;

  public static final int NUMBERS_PER_TICKET = 6;
  public static final int PRICE_PER_TICKET = 1000;

  public static final int NUMBERS_PER_WINNING_NUMBER = 6;

  public static final Function<Boolean, Boolean> doesntCareBonus = x -> true;
  public static final Function<Boolean, Boolean> mustWithBonus = x -> x;
  public static final Function<Boolean, Boolean> mustWithoutBonus = x -> !x;
}
