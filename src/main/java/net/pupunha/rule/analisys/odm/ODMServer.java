package net.pupunha.rule.analisys.odm;

import net.pupunha.rule.analisys.odm.domain.RuleApp;
import net.pupunha.rule.analisys.odm.domain.RuleAppVersion;
import net.pupunha.rule.analisys.odm.domain.RuleSet;
import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ODMServer {

    private static final String AUTHORIZATION_HEADER = "Authorization";

//    String resourceUrl = resUrl + "/api/v1/ruleapps" + ruleSetPath + "/highest?parts=archive";

    private String resServer;

    private String resUser;

    private String resPassword;

    private String generateAuthorization(String resUser, String resPassword) {
        String plainCreds = resUser + ":" + resPassword;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    public List getRuleApps(String resServer, String resUser, String resPassword) {
        String base64Creds = generateAuthorization(resUser, resPassword);
        Client client = ClientBuilder.newClient();
        List response = client.target(resServer)//.register(objectMapper)
                .path("/api/v1/ruleapps")
                .queryParam("parts", "rulesets")
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION_HEADER, "Basic " + base64Creds)
                .get(new GenericType<List>() {});
        return response;
    }

    public Set<RuleApp> wrapperRuleApp(List<Map<String, Object>> ruleAppRest) {

        LinkedHashSet<RuleApp> ruleApps = new LinkedHashSet<>();
        String[] id;
        String ruleapp;
        String ruleappVersion;
        List<Map<String, String>> rulesets;
        String ruleset;
        String rulesetVersion;
        for (Map<String, Object> ruleApp : ruleAppRest) {
            id = ruleApp.get("id").toString().split("[/]");
            ruleapp = id[0];
            ruleappVersion = id[1];

            String finalRuleapp = ruleapp;
            RuleApp matchingRuleApp = ruleApps.stream()
                    .filter(r -> r.getName().equals(finalRuleapp))
                    .findFirst().orElse(null);
            if (matchingRuleApp != null) {



            } else {

                LinkedHashSet<RuleSet> ruleSets = new LinkedHashSet<>();
                List<Map<String, String>> rulesetsMap = (List<Map<String, String>>) ruleApp.get("rulesets");
//                for (Map<String, String> rulesets : rulesetsMap) {
//                    String[] rulesetComplete = rulesets.get("id").split("[/]");
//                    String rulesetName = rulesetComplete[2];
//                    String rulesetVersion = rulesetComplete[3];

//                    ruleSets.add(RuleSet.builder().name(rulesetName).ru)

//                }

//                rulesets = Stream.of().map();
//
//                rulesetVersion = rulesets[3];
//
//                RuleSet ruleSet = RuleSet.builder().name(ruleset)


                RuleAppVersion ruleAppVersion = RuleAppVersion.builder()
                    .version(ruleappVersion)
                    .build();



                ruleApps.add(RuleApp.builder().name(ruleapp).build());
            }

//            RuleAppVersion ruleAppVersion = RuleAppVersion.builder()
//                    .version(ruleappVersion)
//                    .build();

//            ruleApps.add(RuleApp.builder().)
//            ruleApps.add(ruleApp)
//            RuleApp.builder().name()
//            ruleApps.add(RuleApp)
//            RuleApp ra = new RuleApp();

        }



        return null;
    }

}
