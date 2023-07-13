package study;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CollectionsTest {

    @Test
    void unmodifiableAddTest() {
        List<Integer> list = new ArrayList<>();
        assertDoesNotThrow(() -> {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
        });

        List<Integer> unmodifiableList = Collections.unmodifiableList(list);

        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableList.add(1);
            unmodifiableList.add(2);
            unmodifiableList.add(3);
            unmodifiableList.add(4);
            unmodifiableList.add(5);
        });
    }

    @Test
    void unmodifiableRemoveTest() {
        List<Integer> list = new ArrayList<>();
        assertDoesNotThrow(() -> {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
        });

        List<Integer> unmodifiableList = Collections.unmodifiableList(list);

        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableList.remove(1);
            unmodifiableList.remove(2);
            unmodifiableList.remove(3);
            unmodifiableList.remove(4);
            unmodifiableList.remove(5);
        });
    }
}
