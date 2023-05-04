package lotto.step3;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7)
        );

        System.out.println(list.stream().filter(l -> l.contains(6)).count());
//        List<Integer> target = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Set<Integer> a = Set.of(1, 2, 3, 4, 5, 6);

//        Map<Long, List<List<Integer>>> resultMap = list.stream()
//                .filter(lotto -> lotto.stream().anyMatch(a::contains))
//                .collect(Collectors.groupingBy(lotto -> lotto.stream().filter(a::contains).count()));
//
//        resultMap.forEach((key, value) -> System.out.println(key + ", " + value));
//        int bonusNumber = 44;
//        Map<Integer, List<List<Integer>>> stat = new HashMap<>();
//        List<List<Integer>> lo = Arrays.asList(
//                Arrays.asList(4, 5, 12, 31, 38),
//                Arrays.asList(4, 5, 12, 31, 38)
//        );
//
//        stat.put(5, lo);
//
//        System.out.println(stat);
//        System.out.println("----------------");
//
//        List<List<Integer>> lottoList = Arrays.asList(
//                Arrays.asList(4, 5, 12, 31, 38, 44),
//                Arrays.asList(4, 5, 12, 31, 38, 44),
//                Arrays.asList(1, 6, 25, 30, 39, 44)
//        );
//        List<Integer> matchList = Arrays.asList(4, 5, 12, 31, 38, 1);
//
////        List<List<Integer>> bounsList = lottoList.stream()
////                .filter(lotto -> lotto.contains(38))
////                .map()
////                .collect(Collectors.toList());
//
//        List<List<Integer>> bounsList = lottoList.stream()
//                .filter(lotto -> lotto.contains(bonusNumber))
//                .map(lotto -> lotto.stream()
//                        .filter(num -> num != bonusNumber)
//                        .collect(Collectors.toList()))
//                .collect(Collectors.toList());
//
//
//        List<List<Integer>> resultList = lottoList.stream()
//                .filter(lotto -> lotto.stream().anyMatch(matchList::contains))
//                .collect(Collectors.toList());
//
////        System.out.println(resultList);
//        System.out.println(bounsList);
//
//        System.out.println("----------------"+stat.get(5));
//        stat.get(5).stream()
//                .filter(s -> bounsList.stream().anyMatch(l -> l.containsAll(s)))
//                .collect(Collectors.toList()).forEach(System.out::println);


    }

}
