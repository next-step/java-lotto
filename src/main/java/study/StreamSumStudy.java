package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Summing Numbers With Java Streams
 **/
public class StreamSumStudy {
    //reduce(), collect() terminal operation for sum
    //if List<Object> objectList = Arrays.asList(  );
    //where Object(int id, Integer price)
    List<Integer> integers = Arrays.asList(1,2,3,4,5);

    Integer sum1 = integers.stream()
                    //map(x -> x.getPrice())
                    .reduce(0, (a, b) -> a + b);

    Integer sum2 = integers.stream()
                    //map(x -> x.getPrice())
                    .reduce(0, Integer::sum);

    Integer sum3 = integers.stream()
                    //map(x -> x.getPrice())
                    .collect(Collectors.summingInt(Integer::intValue));

    //mapToInt() intermediate operation stream->IntStream by mapper PARAM , then sum() call
    Integer sum4 = integers.stream()
                    //mapToInt(x -> x.getPrice()), 아래 mapToInt()삭제
                    .mapToInt(Integer::intValue)
                    .sum();

    /**
     * Map<Object, Integer> , sum of Values?
     * first create a stream from the values of that Map
     * Integer sum = map.values()
     *                  .stream()
     *                  .mapToInt(Integer::valueOf)
     *                  .sum();
     */

    String string = "Item1 10 Item2 24 Item3 30 Item4 45";

    Integer sum = Arrays.stream(string.split(" "))
            .filter(s -> s.matches("\\d+"))
            .mapToInt(Integer::valueOf)
            .sum();

}