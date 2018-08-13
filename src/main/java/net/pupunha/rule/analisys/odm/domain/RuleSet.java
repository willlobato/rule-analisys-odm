package net.pupunha.rule.analisys.odm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;

@Data
@Builder
@EqualsAndHashCode(of = {"name"})
public class RuleSet {

    private String name;
    private LinkedHashSet<RuleSetVersion> ruleSetVersions;
}
