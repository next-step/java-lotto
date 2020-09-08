```
    /**
     * The Java 8 Stream API Tutorial
     * 2.Stream Creation
     **/
    IntStream intStream = IntStream.range(1, 3);
    LongStream longStream = LongStream.rangeClosed(1, 3);
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);
    IntStream streamOfChars = "abc".chars();

    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(10);
    Stream<String> streamOfString
            = Pattern.compile(", ").splitAsStream("a, b, c");

    /**
     * The Java 8 Stream API Tutorial
     * 3.Referencing a Stream
     **/
    java.util.stream.Stream<String> stream =
            Stream.of("a", "b", "c").filter(element -> element.contains("b"));
    Optional<String> anyElement = stream.findAny();

    /*
     When has IllegalException : terminal operation -> a RuntimeException (x)
     Java 8 streams can't be reused, because it's providedd to apply a
     finite sequence of operations in a functional style, not to store elements
     */

    List<String> elements =
            Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                    .collect(Collectors.toList());
    Optional<String> anyElement2 = elements.stream().findAny();
    Optional<String> firstElement = elements.stream().findFirst();

    /**
     * The Java 8 Stream API Tutorial
     * 4.Stream Pipeline
     **/

    //return a new modified stream
    Stream<String> onceModifiedStream =
            Stream.of("abcd", "bbcd", "cbcd").skip(1);

    //"substitue" everyelement
    Stream<String> twiceModifiedStream =
            stream.skip(1).map(element -> element.substring(0, 3));

    List<String> list = Arrays.asList("abc1", "abc2", "abc3");
    long size = list.stream().skip(1)
            .map(element -> element.substring(0, 3)).sorted().count();

    /**
     * The Java 8 Stream API Tutorial
     * 5.Lazy Invocation
     **/
    //intermediate only when terminal operation execution
    public long counter;

    private void wasCalled() {
        counter++;
    }

    //filter(), filter(), map()
    //first-filter predicatex, second filter() passed, then to map()
    List<String> list2 = Arrays.asList("abc1", "abc2", "abc3");
    Stream<String> stream2 = list2.stream()
            .filter(element -> {
                wasCalled();
                return element.contains("2");
            });

    Optional<String> stream3 = list2.stream()
            .filter(element -> {
                System.out.println("filter() was called");
                return element.contains("2");
            }).map(element -> {
                System.out.println("map() was called");
                return element.toUpperCase();
            }).findFirst();

    /**
     * The Java 8 Stream API Tutorial
     * 6.Order of Execution
     **/

    //wrong map -> skip order
     long size = list.stream()
            .skip(2)
            .map(element -> {
                wasCalled();
                return element.substring(0,3);
            }).count();

public class StreamStudy {

    /**
     * The Java 8 Stream API Tutorial
     * 7.Stream Reduction
     **/

     //primitive term. operations : count(), max(), min(), sum()

     /*
        reduce() : identity - initial value or default when empty
                   accumulator - function logic of aggregation,
                                 new values equals = stream.size(), only the last value useful
                    combiner - function aggregates results, a parallel mode from diff threads
      */

     int reduced = IntStream
                    .range(1,4)
                    .reduce(10, (a,b) -> a + b);//10 + 1,2,3   1+2+3 =  16

     int reducedParallel = Arrays.asList(1,2,3)
                            .parallelStream()
                            .reduce(10, (a , b) -> a + b, (a , b) -> {
                                return a + b;
                            }); // (10 + 1, 10 + 2, 10 + 3) -> ( 11 + (12 + 13) ) = 36
             }

     /*
        collect() - Collectors : primitive type
     */
     private class Product {
         private final int price;
         private final String name;

         Product(int price, String name) {
             this.price = price;
             this.name = name; };

         public int getPrice() {
             return price;
         }
         public String getName() {
             return name;
         }

         // converting a Stream -> Collection (Collection, List or Set)
     List<Product> productList = Arrays.asList(
             new Product(23, "potatoes"), new Product(14, "oranges"),
            new Product(13, "lemon"), new Product(23, "bread"));

     List<String> collectorCollection = productList.stream()
                                        .map(Product::getName)
                                        .collect(Collectors.toList());

     // reducing to String - [potatoes,oranges,lemon,bread] delimiter,prefix,suffix : end no mattter//
     String listToString = productList.stream()
                            .map(Product::getName)
                            .collect(joining(",", "[" , "]"));

     // processing the avg value of all numeric elements of stream
      double averagePrice = productList.stream()
                            .collect(Collectors.averagingInt(Product::getName));

      // processing the sum of all numeric elements of stream
      int summingPrice = productList.stream()
                        .collect(Collectors.summingInt(Product::getPrice));

      //also averagingInt, summarizingInt,summingLong, averagingDouble... primitiv
      //no need to do map() operation before collect()

      //collecting statistical info about stream -> getCount(), getMax(), getSum(), getAverage()
      IntSummaryStatistics statistics = productList.stream()
                                        .collect(Collectors.summarizingInt(Product::getPrice));
      //“IntSummaryStatistics{count=5, sum=86, min=13, average=17,200000, max=23}”;
      Map<Integer, List<Product>> collectorMapOfLists
            = productList.stream()
            .collect(groupingBy(Product::getPrice));
      // groups all products by price : map

      //Dividing stream's elements into groups acc to some predicate
      Map<Boolean, List<Product>> mapPartioned = productList.stream()
                                    .collect(Collectors.partitioningBy(element ->
                                            element.getPrice() > 15));

      //Pushing the collector to perform additional transformation like 'unmodifiableSet'
      Set<Product> unModifiableSet = productList.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.toSet(), Collections::unmodifiableSet));

      //Custom collector:LinkedList add

      Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector.of(
           LinkedList::new, LinkedList::add,
              (first, second) -> {
               first.addAll(second);
               return first;
              });

      LinkedList<Product> linkedListOfProducts = productList.stream()
                                                .collect(toLinkedList);

      /**
       * dzone - groupingBy()  https://dzone.com/articles/the-ultimate-guide-to-the-java-stream-api-grouping
       **/

      //groupby length
      List<String> strings = Arrays.asList("a", "bb", "cc", "ddd");
      Map<Integer, List<String>> result = strings.stream()
                                            .collect(groupingBy(String::length));
      // { 1 = [ a ], 2 = [bb, cc], 3 = [ddd]} here Arrays.asList("bb","cc")

      //groupby count
      Map<Integer, Long> result2 = strings.stream()
                                    .collect(groupingBy(String::length, counting()));
       // { 1 = 1, 2 = 2, 3 = 1}

      //group and combine as String
      Map<Integer, String> result3 = strings.stream()
                                    .collect(groupingBy(String::length, joining(",", "[", "]" )));
      // {1 = [a], 2 =[bb,cc], 3 =[ddd]} here "bb,cc"


//      Map<Integer, List<Character>> result5 = strings.stream()
//                                            .map(toStringList())
//                                            .collect(groupingBy(List::size,
//                                                        reducing(List.of(),
//                                                                (l1, l2) ->
//                                                                Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList()))));
//      System.out.println(result5); // {1 = [a], 2 = [b, b, c, c], 3 = [d, d, d]}

//
//      var result = strings.stream()
//        .collect(
//                groupingBy(String::length,
//                    mapping(toStringList(),
//                        flatMapping(s -> s.stream().distinct(),
//                            filtering(s -> s.length() > 0,
//                                mapping(String::toUpperCase,
//                                    reducing("", (s, s2) -> s + s2))))))
//        );
//
//      //result
//        {1=A, 2=BC, 3=D}

}
```
