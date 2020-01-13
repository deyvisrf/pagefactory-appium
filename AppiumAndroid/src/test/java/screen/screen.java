package screen;

import helper.AppiumDriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class screen {

    private AppiumDriver<MobileElement> driver;

    public screen(AppiumDriver<MobileElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        this.driver = appiumDriver;
    }

    @AndroidFindBy(id = "billAmtEditText")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement campoValor;

    @AndroidFindBy(id = "calcTipButton")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement btnCalcular;

    @AndroidFindBy(id = "totalAmtTextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement totalResultText;

    @AndroidFindBy(id = "tipAmtTextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement tipResultText;

    public void inserirNumero(String valor) {
        campoValor.sendKeys(valor);
    }

    public void calcular(){
        btnCalcular.click();
    }

    public String resultadoTotal() {
        return totalResultText.getText().toString().trim();
    }

    public String resultadoTip() {
        return tipResultText.getText().toString().trim();
    }
}
