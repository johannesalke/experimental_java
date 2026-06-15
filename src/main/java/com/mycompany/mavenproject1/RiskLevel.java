package com.mycompany.mavenproject1;

public enum RiskLevel {
    LOW, MEDIUM, HIGH, PRAXIS;


    public RiskLevel higherRiskLevel() {
        if (this.equals(RiskLevel.PRAXIS)) {
            return RiskLevel.PRAXIS;
        }
        return RiskLevel.values()[this.ordinal() + 1];
    } //You can't use a method to set the current object to a different enum version, but you can return a new enum based on the current one.

}
