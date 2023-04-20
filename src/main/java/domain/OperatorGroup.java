package domain;

import domain.extractor.Extractor;

import java.util.List;

public class OperatorGroup {

    private final List<Operator> operatorList;
    private final OperatorGroupOffset offset;
    private final Extractor<?> extractor;

    private OperatorGroup(List<Operator> operatorList, OperatorGroupOffset offset, Extractor<?> extractor) {
        this.operatorList = operatorList;
        this.offset = offset;
        this.extractor = extractor;
    }
}
