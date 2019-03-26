package lottogame;

import lottogame.controller.IndexController;
import lottogame.controller.LottoTicketController;
import lottogame.controller.ResultController;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class WebApplicationLauncher {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/templates");

        IndexController.index();
        LottoTicketController.getLottoTicket();
        ResultController.getResult();
    }

}
