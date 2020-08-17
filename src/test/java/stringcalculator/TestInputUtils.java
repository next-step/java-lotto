package stringcalculator;

import org.apache.commons.lang3.StringUtils;

public class TestInputUtils {
    public static String replaceLinefeed(String value) {
        if (StringUtils.isNotBlank(value) && value.contains("\\n")) {
            return value.replace("\\n", "\n");
        }

        return value;
    }
}
