package articlesTests.croPricePrediction;

import abstracts.AbstractTest;
import io.qameta.allure.Link;
import org.example.pageElement.ArticlesElements;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AnnouncedLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(AnnouncedLinkTest.class);

    @Test
    @DisplayName("Tect№13: Articles - CRO price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void announcedLinkTest() throws IOException {
        try {
            ArticlesElements tapElement = new ArticlesElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(3000);
            tapElement.tapCroPrice();
            Thread.sleep(5000);
            tapElement.tapAnnounced();
            getAndroidDriver().context("WEBVIEW_chrome");
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (CRO price prediction) AnnouncedLinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (CRO price prediction) AnnouncedLinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("Revised Changes to Crypto.com Visa Cards Update"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://crypto.com/product-news/crypto-com-visa-cards-update"));
        logger.info("(CRO price prediction) AnnouncedLinkTest- passed");
    }
}