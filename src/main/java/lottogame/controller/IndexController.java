package lottogame.controller;

import static spark.Spark.get;

public class IndexController extends AbstractController {

    public static void index() {
        get("/", (req, res) -> renderIndex());
    }

    private static Object renderIndex() {
        return render(null, INDEX_TEMPLATE_PATH);
    }
}
