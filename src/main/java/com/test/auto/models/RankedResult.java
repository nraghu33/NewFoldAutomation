package com.test.auto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Data
public class RankedResult {
    @JsonProperty(value = "PositiveCTALabel", required = false)
    public String positiveCTALabel;
    @JsonProperty(value = "InteractionID", required = false)
    public String interactionID;
    @JsonProperty(value = "Issue", required = false)
    public String issue;
    @JsonProperty(value = "CustomerCost", required = false)
    public int customerCost;
    @JsonProperty(value = "ContentFormat", required = false)
    public String contentFormat;
    @JsonProperty(value = "Label", required = false)
    public String label;
    @JsonProperty(value = "Benefits", required = false)
    public String benefits;
    @JsonProperty(value = "WhyRelevant", required = false)
    public String whyRelevant;
    @JsonProperty(value = "NeutralCTALabel", required = false)
    public String neutralCTALabel;
    @JsonProperty(value = "Name", required = false)
    public String name;
    @JsonProperty(value = "ShortDescription", required = false)
    public String shortDescription;
    @JsonProperty(value = "PaidAudienceName", required = false)
    public String paidAudienceName;
    @JsonProperty(value = "Identifier", required = false)
    public String identifier;
    @JsonProperty(value = "Placement", required = false)
    public String placement;
    @JsonProperty(value = "PriceDiscountTerm", required = false)
    public String priceDiscountTerm;
    @JsonProperty(value = "JourneyStep", required = false)
    public String journeyStep;
    @JsonProperty(value = "LaunchDomainSpinner", required = false)
    public String launchDomainSpinner;
    @JsonProperty(value = "CTAType", required = false)
    public String cTAType;
    @JsonProperty(value = "Propensity", required = false)
    public double propensity;
    @JsonProperty(value = "ProductCode", required = false)
    public String productCode;
    @JsonProperty(value = "AgentCompensation", required = false)
    public int agentCompensation;
    @JsonProperty(value = "ClassIdentifier", required = false)
    public String classIdentifier;
    @JsonProperty(value = "Registry_premium", required = false)
    public String registry_premium;
    @JsonProperty(value = "Priority", required = false)
    public double priority;
    @JsonProperty(value = "Channel", required = false)
    public String channel;
    @JsonProperty(value = "BundleName", required = false)
    public String bundleName;
    @JsonProperty(value = "ImageURL", required = false)
    public String imageURL;
    @JsonProperty(value = "Variant", required = false)
    public String variant;
    @JsonProperty(value = "InternalCost", required = false)
    public int internalCost;
    @JsonProperty(value = "Aftermarket", required = false)
    public String aftermarket;
    @JsonProperty(value = "Icon", required = false)
    public String icon;
    @JsonProperty(value = "Tld_suggestions", required = false)
    public String tld_suggestions;
    @JsonProperty(value = "Journey", required = true)
    public String journey;
    @JsonProperty(value = "Group", required = false)
    public String group;
    @JsonProperty(value = "Category", required = false)
    public String category;
    @JsonProperty(value = "Tld", required = false)
    public String tld;
    @JsonProperty(value = "Direction", required = false)
    public String direction;
    @JsonProperty(value = "Pricing", required = false)
    public String pricing;
    @JsonProperty(value = "JourneyStage")
    public String journeyStage;
    @JsonProperty(value = "Sld_suggestions", required = false)
    public String sld_suggestions;
    @JsonProperty(value = "EligibilityDescription", required = false)
    public String eligibilityDescription;
    @JsonProperty(value = "Rank", required = false)
    public int rank;
    @JsonProperty(value = "BundleParent", required = false)
    public String bundleParent;
    @JsonProperty(value = "Treatment", required = false)
    public String treatment;
    @JsonProperty(value = "CampaignID", required = false)
    public String campaignID;
    @JsonProperty(value = "NegativeCTALabel", required = false)
    public String negativeCTALabel;
    @JsonProperty(value = "OfferValue", required = false)
    public int offerValue;
    @JsonProperty(value = "PositioningStmt", required = false)
    public String positioningStmt;
    @JsonProperty(value = "ClickThroughURL", required = false)
    public String clickThroughURL;
    @JsonProperty(value = "DecisionTime", required = false)
    public String decisionTime;

    @JsonProperty(value = "OnPageDisclaimer", required = false)
    public String onPageDisclaimer;
    @JsonProperty(value = "AEMContentFragmentDynamicCTB", required = false)
    public String aEMContentFragmentDynamicCTB;
    @JsonProperty(value = "PageSubHeader", required = false)
    public String pageSubHeader;
    @JsonProperty(value = "CardID", required = false)
    public String cardID;
    @JsonProperty(value = "ModalDisclaimer", required = false)
    public String modalDisclaimer;
    @JsonProperty(value = "TemplateIDDynamicCTB", required = false)
    public String templateIDDynamicCTB;
    @JsonProperty(value = "PageHeader", required = false)
    public String pageHeader;
    @JsonProperty(value = "AEMContentFragmentVariation", required = false)
    public String aEMContentFragmentVariation;
    @JsonProperty(value = "CardBanner", required = false)
    public String cardBanner;
    @JsonProperty(value = "TemplateID", required = false)
    public String templateID;

    @JsonProperty(value = "TemplateID", required = false)

    @Override
    public String toString() {
        return "RankedResult [positiveCTALabel=" + positiveCTALabel + ", interactionID=" + interactionID + ", issue="
                + issue + ", customerCost=" + customerCost + ", contentFormat=" + contentFormat + ", label=" + label
                + ", benefits=" + benefits + ", whyRelevant=" + whyRelevant + ", neutralCTALabel=" + neutralCTALabel
                + ", name=" + name + ", shortDescription=" + shortDescription + ", paidAudienceName=" + paidAudienceName
                + ", identifier=" + identifier + ", placement=" + placement + ", priceDiscountTerm=" + priceDiscountTerm
                + ", journeyStep=" + journeyStep + ", launchDomainSpinner=" + launchDomainSpinner + ", cTAType="
                + cTAType + ", propensity=" + propensity + ", productCode=" + productCode + ", agentCompensation="
                + agentCompensation + ", classIdentifier=" + classIdentifier + ", registry_premium=" + registry_premium
                + ", priority=" + priority + ", channel=" + channel + ", bundleName=" + bundleName + ", imageURL="
                + imageURL + ", variant=" + variant + ", internalCost=" + internalCost + ", aftermarket=" + aftermarket
                + ", icon=" + icon + ", tld_suggestions=" + tld_suggestions + ", journey=" + journey + ", group="
                + group + ", category=" + category + ", tld=" + tld + ", direction=" + direction + ", pricing="
                + pricing + ", journeyStage=" + journeyStage + ", sld_suggestions=" + sld_suggestions
                + ", eligibilityDescription=" + eligibilityDescription + ", rank=" + rank + ", bundleParent="
                + bundleParent + ", treatment=" + treatment + ", campaignID=" + campaignID + ", negativeCTALabel="
                + negativeCTALabel + ", offerValue=" + offerValue + ", positioningStmt=" + positioningStmt
                + ", clickThroughURL=" + clickThroughURL + ", decisionTime=" + decisionTime + ", onPageDisclaimer="
                + onPageDisclaimer + ", aEMContentFragmentDynamicCTB=" + aEMContentFragmentDynamicCTB
                + ", pageSubHeader=" + pageSubHeader + ", cardID=" + cardID + ", modalDisclaimer=" + modalDisclaimer
                + ", templateIDDynamicCTB=" + templateIDDynamicCTB + ", pageHeader=" + pageHeader
                + ", aEMContentFragmentVariation=" + aEMContentFragmentVariation + ", cardBanner=" + cardBanner
                + ", templateID=" + templateID + "]";
    }

}
