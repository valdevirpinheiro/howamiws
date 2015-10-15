
package br.com.eacsoftware.howamiws;

import org.junit.Test;

import br.com.eacsoftware.howamiws.wsimp.AppWSImp;
import static org.junit.Assert.assertEquals;

public class AppImplTest {

    @Test
    public void testSayHi() {
        AppWSImp helloWorldImpl = new AppWSImp();
        String response = helloWorldImpl.sayHi("Sam");
        assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam", response);
    }
}
