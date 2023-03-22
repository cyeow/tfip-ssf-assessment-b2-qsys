package tfip.ssfassessmentb2qsys.model;

// DO NOT MODIFY THIS FILE

import java.util.HashMap;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Quotation {

    private String quoteId;
    private Map<String, Float> quotations = new HashMap<>();

    public Quotation(String quoteId, Map<String, Float> quotations) {
        this.quoteId = quoteId;
        this.quotations = quotations;
    }
    public Quotation() {
    }
    public String getQuoteId() {
        return quoteId;
    }
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Map<String, Float> getQuotations() {
        return quotations;
    }
    public void setQuotations(Map<String, Float> quotations) {
        this.quotations = quotations;
    }
    public void addQuotation(String item, Float unitPrice) {
        this.quotations.put(item, unitPrice);
    }
    public Float getQuotation(String item) {
        return this.quotations.getOrDefault((Object)item, -1000000f);
    }

    public String toJSONString() {
        return this.toJSON().toString();
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
        .add("quoteId", quoteId)
        .add("quotations", quotations.toString())
        .build();
    }
}