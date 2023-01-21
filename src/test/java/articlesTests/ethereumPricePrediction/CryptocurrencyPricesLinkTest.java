package articlesTests.ethereumPricePrediction;

import abstractSetting.AbstractTest;
import io.qameta.allure.Link;
import org.example.pageElements.EthereumPricePredictionElements;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CryptocurrencyPricesLinkTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(CryptocurrencyPricesLinkTest.class);

    @Test
    @DisplayName("Tect№22: Articles - Ethereum price prediction")
    @Link("https://docs.google.com/spreadsheets/d/1cz-FGYsjfpLtaogip9UvuRrUE50nLWkGCkXN2xP-6fE/edit?usp=sharing")
    void etherPriceLinkTest() throws IOException {
        try {
            EthereumPricePredictionElements tapElement = new EthereumPricePredictionElements(getAndroidDriver());
            tapElement.goToArticles();
            Thread.sleep(2000);
            tapElement.tapEthereumPricePrediction();
            Thread.sleep(3000);
            tapElement.tapCryptocurrencyPrices();
            getAndroidDriver().context("WEBVIEW_chrome");
            System.out.println(getAndroidDriver().getTitle());
            System.out.println(getAndroidDriver().getCurrentUrl());
        } catch (Exception e) {
            File file = MyUtils.makeScreenshot(getAndroidDriver(), "failure- org.example.articlesTests (Ethereum price prediction) CryptocurrencyPricesLinkTest- False" + System.currentTimeMillis() + ".png");
            MyUtils.saveScreenshot(Files.readAllBytes(file.toPath()));
            logger.error("org.example.articlesTests (Ethereum price prediction) CryptocurrencyPricesLinkTest- False");
        }
        Assertions.assertTrue(getAndroidDriver().getTitle().equals("ETH/USD Chart | Live Ethereum to US Dollar Price"));
        Assertions.assertTrue(getAndroidDriver().getCurrentUrl().equals("https://capital.com/eth-usd-chart"));
        logger.info("(Ethereum price prediction) CryptocurrencyPricesLinkTest- passed");
    }
}