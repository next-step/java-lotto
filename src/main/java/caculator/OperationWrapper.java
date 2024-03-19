package caculator;

import java.util.ArrayList;
import java.util.List;

public class OperationWrapper {

    private static final int INITIAL_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int PAIR_SIZE = 2;
    private final Number initNumber;
    private final List<OperationPair> pairs;

    public OperationWrapper(Number initNumber, List<OperationPair> pairs) {
        this.initNumber = initNumber;
        this.pairs = pairs;
    }

    public OperationWrapper(List<String> textArray) {
        this.initNumber = extractInitialNumber(textArray);
        this.pairs = makePairs(textArray);
    }

    private Number extractInitialNumber(List<String> textArray) {
        return new Number(textArray.get(INITIAL_INDEX));
    }

    private List<OperationPair> makePairs(List<String> textArray) {
        List<OperationPair> pairs = new ArrayList<>();

        int limit = isOdd(textArray.size()) ? textArray.size() : textArray.size() - 1;

        for (int i = SECOND_INDEX; i < limit; i = i + PAIR_SIZE) {
            pairs.add(new OperationPair(textArray.get(i), textArray.get(i + 1)));
        }
        return pairs;
    }

    public List<OperationPair> getOperationPairs() {
        return this.pairs;
    }

    public Number getInitNumber() {
        return initNumber;
    }


    private boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
