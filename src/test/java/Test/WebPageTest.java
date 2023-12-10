package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.tests.WebPage;

public class WebPageTest {
    protected WebPage webPage;

    @Before
    public void open(){
        webPage = new WebPage();
        webPage.openPage();
    }
    @Test
    public void login(){
        webPage.login();
    }
    @After
    public void close(){
        webPage.closePage();
    }
}