package calculator;

import java.util.regex.Pattern;

public class DefaultSplitter implements Splitter {

    @Override
    public SplitNumber split(String str) {
        Pattern pattern = SplitType.DEFAULT.getPattern();
        return new SplitNumber(pattern.split(str));
    }
}
