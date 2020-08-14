package calculator.model;

import java.util.Arrays;
import java.util.List;

public class BasicSeparator implements Separator {

    private static final String DEFAULT_DELIMITER = ",|:";

    private BasicSeparator() {
    }

    private static class InnerInstance {
        private static final BasicSeparator uniqueInstance = new BasicSeparator();
    }

    public static BasicSeparator of() {
        return InnerInstance.uniqueInstance;
    }

    @Override
    public List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

}
