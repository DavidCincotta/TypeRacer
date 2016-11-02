/**
 * Created by David on 10/29/16.
 */
import com.sun.tools.javac.util.*;
import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TypeRacerMain {

    static Robot bot;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "../../downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://play.typeracer.com/");
        System.out.println("before Robot");
        try {
            bot = new Robot();
            Thread.sleep(1000);
            bot.keyPress(KeyEvent.VK_META);
            bot.keyPress(KeyEvent.VK_SPACE);
            bot.keyRelease(KeyEvent.VK_META);
            bot.keyRelease(KeyEvent.VK_SPACE);
            type("Firefox");
            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            bot.mouseMove(300,305);
            bot.mousePress(InputEvent.BUTTON1_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_MASK);
            System.out.println("In Race");

            Thread.sleep(11000);
            String typeRacerBox = "";
            List elements = (List) driver.findElements(By.tagName("span"));
            System.out.println(elements);
            type("helloWorld");

        } catch (Exception e) {
            System.out.println(e);
        }
        Thread.sleep(20000);
        driver.quit();
        System.out.println("Done");
    }

    private void leftClick() {
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.delay(200);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        bot.delay(200);
    }

    private void type(int i) {
        bot.delay(40);
        bot.keyPress(i);
        bot.keyRelease(i);
    }

    private static void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            bot.delay(40);
            bot.keyPress(code);
            bot.keyRelease(code);
            if (code==58){
                bot.keyPress(KeyEvent.VK_SHIFT);
                bot.keyPress(KeyEvent.VK_SEMICOLON);
                bot.keyRelease(KeyEvent.VK_SHIFT);
                bot.keyRelease(KeyEvent.VK_SEMICOLON);
            }
        }
    }
}