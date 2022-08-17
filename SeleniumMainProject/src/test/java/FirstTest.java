import Browser.Browser;
import org.testng.annotations.Test;

public record FirstTest() {
    @Test
        public void test1(){
            Browser.setDriver();
        }
}

