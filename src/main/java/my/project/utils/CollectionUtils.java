package my.project.utils;

import my.project.messages.ExceptionMessages;

import java.util.List;

public class CollectionUtils {

    public static void isListQualified(List<?> param) {
        if (param == null || param.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.COLLECTION_IS_NULL);
        }
    }

    private CollectionUtils() {
    }
}
