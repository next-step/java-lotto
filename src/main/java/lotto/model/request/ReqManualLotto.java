package lotto.model.request;

import java.util.List;

public class ReqManualLotto implements ReqLotto {

    private final List<String> requestNumberList;

    public ReqManualLotto(List<String> requestNumberList) {
        this.requestNumberList = requestNumberList;
    }

    public List<String> getRequestNumberList() {
        return requestNumberList;
    }
}
