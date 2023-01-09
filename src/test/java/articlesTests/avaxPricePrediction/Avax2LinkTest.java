package articlesTests.avaxPricePrediction;

import abstracts.AbstractTest;
import io.qameta.allure.Link;
import org.example.pageElement.AvaxPricePrediction;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Avax2LinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(Avax2LinkTest.class);

    @Test
    @DisplayName("Tect№6: Articles - AVAX price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void avax2LinkTest() throws IOException {
        try {
            AvaxPricePrediction tapElement = new AvaxPricePrediction(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(3000);
            tapElement.tapAvaxPricePrediction();
            Thread.sleep(3000);
            tapElement.tapAvax2();
            getAndroidDriver().context("WEBVIEW_chrome");
            System.out.println(getAndroidDriver().getTitle());
            System.out.println(getAndroidDriver().getCurrentUrl());
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (AVAX price prediction) Avax2LinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (AVAX price prediction) Avax2LinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("AVAX/USD Chart | Live AVAX to US Dollar Price"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/avax-to-us-dollar-chart"));
        logger.info("(AVAX price prediction) Avax2LinkTest- passed");
    }
}