package articlesTests.ethereumPricePrediction;

import abstracts.AbstractTest;
import io.qameta.allure.Link;
import org.example.pageElement.EthereumPricePredictionElements;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Btc2LinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(Btc2LinkTest.class);

    @Test
    @DisplayName("Tect№6: Articles - Ethereum price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void btc2LinkTest() throws IOException {
        try {
            EthereumPricePredictionElements tapElement = new EthereumPricePredictionElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(2000);
            tapElement.tapEthereumPricePrediction();
            Thread.sleep(2000);
            tapElement.tapBt();
            getAndroidDriver().context("WEBVIEW_chrome");
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (Ethereum price prediction) Btc2LinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (Ethereum price prediction) Btc2LinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("BTC/USD Chart | Live Bitcoin to US Dollar Price"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/btc-usd-chart"));
        logger.info("(Ethereum price prediction) Btc2LinkTest- passed");
    }
}
