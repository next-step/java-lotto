import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

public class Operations {
    private static final Pattern OPERATION_PATTERN = Pattern.compile("[+\\-*/]");

    private List<Operation> operationList = new ArrayList<>();

    public boolean isOperation(String element) {
        Matcher operationMatcher = OPERATION_PATTERN.matcher(element);
        if (operationMatcher.find()) {
            return true;
        }
        return false;
    }

    public void addOperation(String element) {
        operationList.add(Operation.getOperationByElement(element));
    }

    public final List<Operation> findAllOperation() {
        return Collections.unmodifiableList(operationList);
    }

    public int getLengthOfOperations() {
        return operationList.size();
    }
}
