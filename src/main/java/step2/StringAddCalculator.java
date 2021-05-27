package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DELIMITER_INDEX_IN_ARRAY = 0;
    private static final int SPLIT_DATA_INDEX_IN_ARRAY = 1;
    private static final Pattern VALID_DATA_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP_INDEX_IN_MATCHER = 1;
    private static final int SPLIT_DATA_GROUP_INDEX_IN_MATCHER = 2;


    public int calculate(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }
        String[] numbers = splitToNumbers(data);
        return addNumbers(numbers);
    }

    private String[] splitToNumbers(String data) {
        // class 분리

        DelimiterExtractor extractor = new DelimiterExtractor();
        String delimiter = extractor.extractDelimiter(data);
        return splitDataWithDelimiter(extractor.getSplitData(),delimiter);

        // 메소드 분리
//        String[] delimiterAndSplitData = getDelimiterAndSplitData(data);
//        String delimiter = delimiterAndSplitData[DELIMITER_INDEX_IN_ARRAY];
//        String splitData = delimiterAndSplitData[SPLIT_DATA_INDEX_IN_ARRAY];
//
//        return splitDataWithDelimiter(splitData, delimiter);
    }

    private String[] getDelimiterAndSplitData(String data) {
        Matcher delimiterMatcher = DELIMITER_PATTERN.matcher(data);
        if (delimiterMatcher.find()) {
            return new String[] {Pattern.quote(delimiterMatcher.group(DELIMITER_GROUP_INDEX_IN_MATCHER)),
                    delimiterMatcher.group(SPLIT_DATA_GROUP_INDEX_IN_MATCHER)};
        }
        return new String[] { DEFAULT_DELIMITER, data};
    }

    private String[] splitDataWithDelimiter(String splitData, String delimiter) {
        return splitData.split(delimiter);
    }

    private int addNumbers(String[] numbers) {
        int total = 0;
        for ( String number : numbers) {
            total += parseInt(number);
        }
        return total;
    }

    private int parseInt(String number) {
        Matcher matcher = VALID_DATA_PATTERN.matcher(number);
        if (matcher.find()) {
            return Integer.parseInt(number);
        }
        throw new RuntimeException("invalid data");
    }



}
