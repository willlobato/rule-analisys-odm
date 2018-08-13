package net.pupunha.rule.analisys.odm;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ODMServerTest {

    @Test
    public void getRuleApp() throws IOException {
        ODMServer server = new ODMServer();
        List ruleApps = server.getRuleApps("http://localhost:9060/res", "odmAdmin", "odmAdmin");
        Set set = server.wrapperRuleApp(ruleApps);
        System.out.println(set);

    }
}