package lotto.domain;

public class PrizeDto {
  private ConditionDto conditionDto;
  private AmountDto amountDto;

  public PrizeDto(Prize prize) {
    this.conditionDto = new ConditionDto(prize.condition());
    this.amountDto = new AmountDto(prize.amount());
  }

  public ConditionDto getCondition() {
    return this.conditionDto;
  }

  public AmountDto getAmountDto() {
    return this.amountDto;
  }
}
