package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainsTest {
    @Test
    void contains() {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 6, 5, 4));//내거
        arrayList.sort(Integer::compareTo);
        boolean contains = arrayList.contains(1);//당첨자거
        System.out.println("arrayList = " + arrayList);
        System.out.println("contains = " + contains);
        // 사용자번호목록.contains(당첨번호1)
        // 사용자번호목록.contains(당첨번호2)...
        // 사용자번호목록.contains(당첨번호6)
    }
}
