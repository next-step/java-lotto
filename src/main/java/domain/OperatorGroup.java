package domain;

import java.util.List;

public class OperatorGroup {

    private final List<Operator> operatorList;
    private final OperatorGroupOffset offset;


    private OperatorGroup(List<Operator> operatorList,OperatorGroupOffset offset){
        this.operatorList = operatorList;
        this.offset = offset;
    }
}
