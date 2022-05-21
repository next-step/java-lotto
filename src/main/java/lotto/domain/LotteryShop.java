package lotto.domain;

import static java.util.stream.Collectors.toList;

import calculator.Splitter;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.money.Money;
import lotto.domain.strategy.GenerateNumbersStrategy;

public class LotteryShop {

  public static final Money PRICE_PER_PLAY_FOR_LOTTO = Money.createWon(1000);
  private static final String DELIMITER = ",";
  private static final String WHITESPACE_REGEX = "\\s+";
  private static final int START_TICKET_COUNT = 0;

  public LottoTickets sell(Money purchaseAmount, GenerateNumbersStrategy generateNumbersStrategy) {
    checkGreaterThanMinimumPrice(purchaseAmount);

    List<LottoTicket> lottoTickets = IntStream.range(START_TICKET_COUNT,
            getAvailableLottoTicketCount(purchaseAmount))
        .mapToObj(i -> createLottoTicket(createLottoNumbers(generateNumbersStrategy)))
        .collect(toList());
    return new LottoTickets(lottoTickets, Collections.emptyList());
  }

  public LottoTickets sell(Money purchaseAmount, GenerateNumbersStrategy generateNumbersStrategy,
      List<String> manualLottoNumbers) {
    validate(purchaseAmount, generateNumbersStrategy, manualLottoNumbers);

    int availableLottoTicketCount = getAvailableLottoTicketCount(purchaseAmount);
    int randomLottoTicketCount = availableLottoTicketCount - manualLottoNumbers.size();

    List<LottoTicket> manualLottoTickets = manualLottoNumbers.stream()
        .map(LotteryShop::splitAsList)
        .map(LottoTicket::new)
        .collect(toList());

    List<LottoTicket> randomLottoTickets = IntStream.range(START_TICKET_COUNT,
            randomLottoTicketCount)
        .mapToObj(i -> createLottoTicket(createLottoNumbers(generateNumbersStrategy)))
        .collect(toList());

    return new LottoTickets(manualLottoTickets, randomLottoTickets);
  }

  private void validate(Money purchaseAmount, GenerateNumbersStrategy generateNumbersStrategy,
      List<String> manualLottoNumbers) {
    validateStrategy(generateNumbersStrategy);
    checkGreaterThanMinimumPrice(purchaseAmount);
    validateManualLottoNumbers(manualLottoNumbers);
    validateManualLottoSize(purchaseAmount, manualLottoNumbers);
  }

  private void validateStrategy(GenerateNumbersStrategy generateNumbersStrategy) {
    if (generateNumbersStrategy == null) {
      throw new IllegalArgumentException("번호 생성 전략은 null 일 수 없습니다.");
    }
  }

  private void validateManualLottoSize(Money purchaseAmount, List<String> manualLottoNumbers) {
    int availableLottoTicketCount = getAvailableLottoTicketCount(purchaseAmount);
    int manualLottoSize = manualLottoNumbers.size();
    if (manualLottoSize > availableLottoTicketCount) {
      throw new IllegalArgumentException(String.format("수동 구매 로또 개수(%d)가 구입 가능한 개수(%d)보다 많을 수 없습니다",
          manualLottoSize, availableLottoTicketCount));
    }
  }

  private void validateManualLottoNumbers(List<String> manualLottoNumbers) {
    if (manualLottoNumbers == null) {
      throw new IllegalArgumentException("수동 로또 번호는 null 일 수 없습니다.");
    }
  }

  private int getAvailableLottoTicketCount(Money receivedMoney) {
    return receivedMoney.divide(PRICE_PER_PLAY_FOR_LOTTO).value();
  }

  private void checkGreaterThanMinimumPrice(Money purchaseMoney) {
    if (purchaseMoney.lessThan(PRICE_PER_PLAY_FOR_LOTTO)) {
      throw new IllegalArgumentException(String.format("로또 1장의 가격은 %s 입니다",
          PRICE_PER_PLAY_FOR_LOTTO.won()));
    }
  }

  private static List<Integer> splitAsList(String string) {
    return Splitter.split(string, DELIMITER)
        .stream()
        .map(LotteryShop::removeWhitespace)
        .map(Integer::parseInt)
        .collect(toList());
  }

  private static String removeWhitespace(String s) {
    return s.replaceAll(WHITESPACE_REGEX, "");
  }

  private LottoTicket createLottoTicket(List<Integer> lottoNumbers) {
    return new LottoTicket(lottoNumbers);
  }

  private List<Integer> createLottoNumbers(GenerateNumbersStrategy generateNumbersStrategy) {
    return generateNumbersStrategy.generate();
  }
}
