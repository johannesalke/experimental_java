package com.mycompany.mavenproject1;

public enum RiskLevel {
    LOW, MEDIUM, HIGH, PRAXIS;


    public RiskLevel higherRiskLevel() {
        if (this.equals(RiskLevel.PRAXIS)) {
            return RiskLevel.PRAXIS;
        }
        return RiskLevel.values()[this.ordinal() + 1];
    }

}
