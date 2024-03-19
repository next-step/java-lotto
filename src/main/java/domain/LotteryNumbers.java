package domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbers {
  private final List<LotteryNumber> numbers;

  public LotteryNumbers(final List<LotteryNumber> numbers) {
    this.numbers = numbers;
  }

  public static LotteryNumbers of(final LotteryNumber... numbers) {
    return new LotteryNumbers(List.of(numbers));
  }

  public static LotteryNumbers of(final int... numbers) {
    return new LotteryNumbers(Arrays.stream(numbers).mapToObj(LotteryNumber::of).collect(Collectors.toList()));
  }

  public PositiveNumber matchCount(final LotteryNumbers comparison) {
//    final int FIRST_INDEX = 0;
//    int count =0 ;
//    for (int i = FIRST_INDEX; i < this.numbers.size(); i++) {
//      if (this.numbers.get(i).equals(comparison.numbers.get(i))) {
//        count++;
//      }
//    }

    int count = IntStream.range(0, this.numbers.size())
            .reduce(0, (acc, cur) -> {
              if (this.numbers.get(cur).equals(comparison.numbers.get(cur))) {
                return ++acc;
              }
              return acc;
            });
    return PositiveNumber.of(count);
  }

  public boolean sizeOf(final PositiveNumber size) {
    return size.equals(this.numbers.size());
  }

  @Override
  public String toString() {
    final String OPENER = "[";
    final String CLOSER = "]";
    final String CONNECTOR = ",";

    StringBuilder sb = new StringBuilder(OPENER);
    for (LotteryNumber number : this.numbers) {
      sb.append(number + CONNECTOR.concat(" "));
    }

    final int STARTING_INDEX = 0;
    return sb.substring(STARTING_INDEX, sb.length() - CONNECTOR.length()).concat(CLOSER);
  }
}