package study;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Working With Maps Using Streams
 */
public class StreamForMapStudy {
    Map<String, Integer> someMap = new HashMap<>();
    /**
     * Set of Map.Entry<String,Integer>  : key-value .entrySet();
     * Set of String(Key Object) : key .keySet();
     * Collection<Integer(Value ObjecT)> : value : values();
     */
    Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
    Set<String> keySet = someMap.keySet();
    Collection<Integer> values = someMap.values();

    Stream<Map.Entry<String, Integer>> entriesStream = entries.stream(); //someMap.entrySet().stream()
    Stream<String> keyStream = keySet.stream();     //someMap.keySet().stream()
    Stream<Integer> valuesStream = values.stream(); // someMap.values().stream()

    /**
     * 3.Getting a Map's Keys Using Streams
     */
    Map<String, String> books = new HashMap<>();
        books.put("000-000","book1");
        books.put("111-111","book2 Sang");
        books.put("111-000","book2 Ha");

    //interested in any key for a book matching title "book1"
    //bookTitle may not exist in our shelf : Optional<String>
    //only want Key of each entry : map -> map.Entry<> .getKey()
    //findFirst() terminal Operation is Optional<String>
    Optional<String> optionalIsbn = books.entrySet()
            .stream()
            .filter(book -> "book1".equals(book.getValue()))
            .map(Map.Entry::getKey)
            .findFirst();

    // assertEquals("000-000", optionalIsbn.get());

    //mutiple results matching title "book2"
    //collect( to List())

    List<String> isbnCodes = books.entrySet()
            .stream()
            .filter(e -> e.getValue().startsWith("book2"))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

    /**
     * 4.Getting a Map's Values Using Streams
     */
    //stream entrySet, filter, then map to make Stream Of values, and Collect
    List<String> titles = books.entrySet()
            .stream()
            .filter(e -> e.getKey().startsWith("111-"))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
//    assertEquals(2, titles.size());
//    assertTrue(titles.contains("book2 Sang"));
}

