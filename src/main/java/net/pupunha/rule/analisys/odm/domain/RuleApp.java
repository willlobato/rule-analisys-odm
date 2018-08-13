package net.pupunha.rule.analisys.odm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;

@Data
@Builder
@EqualsAndHashCode(of = {"name"})
public class RuleApp {

    private String name;
    private LinkedHashSet<RuleAppVersion> ruleAppVersions;

}
