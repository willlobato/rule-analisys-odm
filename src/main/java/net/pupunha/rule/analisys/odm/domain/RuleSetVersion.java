package net.pupunha.rule.analisys.odm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = {"version"})
public class RuleSetVersion {

    private String version;

}
