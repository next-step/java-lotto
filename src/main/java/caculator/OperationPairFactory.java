package caculator;

import java.util.ArrayList;
import java.util.List;

public class OperationPairFactory {

    private static final int INITIAL_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int PAIR_SIZE = 2;
    private final Number initNumber;
    private final List<OperationPair> pairs;

    public OperationPairFactory(Number initNumber, List<OperationPair> pairs) {
        this.initNumber = initNumber;
        this.pairs = pairs;
    }

    public OperationPairFactory(List<String> textArray) {
        this.initNumber = extractInitialNumber(textArray);
        this.pairs = makePairs(textArray);
    }

    private Number extractInitialNumber(List<String> textArray) {
        return new Number(textArray.get(INITIAL_INDEX));
    }

    private List<OperationPair> makePairs(List<String> textArray) {
        List<OperationPair> pairs = new ArrayList<>();

        for (int i = SECOND_INDEX; i < textArray.size(); i = i + PAIR_SIZE) {
            if (i + PAIR_SIZE > textArray.size()) {
                return pairs;
            }
            pairs.add(new OperationPair(textArray.get(i), textArray.get(i + 1)));
        }
        return pairs;
    }
}
