package calculator;

public class SingleSplitter implements Splitter {

    @Override
    public SplitNumber split(String str) {
        return new SplitNumber(new String[]{str});
    }
}
