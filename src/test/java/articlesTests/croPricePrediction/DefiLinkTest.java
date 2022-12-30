package articlesTests.croPricePrediction;

import abstracts.AbstractTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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

public class DefiLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(DefiLinkTest.class);

    @Test
    @DisplayName("Tect№3: Articles - CRO price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void deFiLinkTest() throws IOException {
        try {
            TouchAction touchAction = new TouchAction(getAndroidDriver());
            ArticlesElements tapElement = new ArticlesElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(3000);
            tapElement.tapCroPrice();
            Thread.sleep(3000);
            touchAction
                    .press(PointOption.point(620, 2000))
                    .moveTo(PointOption.point(620, 700))
                    .release()
                    .perform();

            tapElement.tapDeFi();
            Thread.sleep(15000);
            getAndroidDriver().context("WEBVIEW_chrome");
            Thread.sleep(3000);
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (CRO price prediction)  DeFiLinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (CRO price prediction) DeFiLinkTest- False");
        }
         Assertions.assertTrue(getAndroidDriver().getTitle().equals("What is DeFi? | Definition and Meaning | Capital.com"));
         Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/defi-definition"));
        logger.info("(CRO price prediction) DeFiLinkTest- passed");
    }
}