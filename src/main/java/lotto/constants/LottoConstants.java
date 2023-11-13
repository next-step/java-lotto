package lotto.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoConstants {
    int PRICE_PER_TICKET = 1000;
    int NUMBER_COUNT = 6;
    int NUMBER_MIN = 1;
    int NUMBER_MAX = 45;

    String PURCHASE_ERROR_MESSAGE = String.format("로또를 구매할 금액이 부족합니다. 로또 한장의 가격은 %s원 입니다.", PRICE_PER_TICKET);
    String NUMBER_ERROR_MESSAGE = String.format("로또 번호는 %s ~ %s 사이의 숫자이어야 합니다.", NUMBER_MIN, NUMBER_MAX);
    String NUMBER_COUNT_ERROR_MESSAGE = String.format("로또 번호는 총 6자리 입니다", NUMBER_COUNT);

    List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
}
