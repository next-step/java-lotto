package helper;

import java.util.Collection;
import java.util.Objects;

/**
 * @author han
 */
public class CollectionHelper {

    public static boolean nullOrEmpty(Collection collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    private CollectionHelper() {
    }
}
