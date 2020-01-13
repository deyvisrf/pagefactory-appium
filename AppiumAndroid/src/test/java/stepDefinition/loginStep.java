package stepDefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helper.AppiumDriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screen.screen;

import static org.junit.Assert.assertTrue;

public class loginStep {

    screen home;

    @Dado("^que quero insiro o valor \"([^\"]*)\"para o cálculo$")
    public void queQueroInsiroOValorParaOCálculo(String valorDoCalculo) {
        home = new screen(AppiumDriverHelper.getDriver());
        home.inserirNumero(valorDoCalculo);
    }

    @Quando("^realizo o cálculo$")
    public void realizoOCálculo() {
        home.calcular();
    }

    @Então("^vejo o percentual Total Amount de \"([^\"]*)\"$")
    public void vejoOPercentualTotalAmountDe(String totalText) {
        assertTrue(home.resultadoTotal().equals(totalText));
    }

    @E("^o tip Amount \"([^\"]*)\"$")
    public void oTipAmount(String tipText) {
        assertTrue(home.resultadoTip().equals(tipText));
    }
}
