package net.pupunha.rule.analisys.odm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;

@Data
@Builder
@EqualsAndHashCode(of = {"version"})
public class RuleAppVersion {

    private String version;
    private LinkedHashSet<RuleSet> ruleSets;

}
