package tfip.ssfassessmentb2qsys.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import tfip.ssfassessmentb2qsys.model.Quotation;

@Service
public class QSysService {
    private static final Map<String, Float> quotations = new HashMap<>();

    static {
        quotations.put("apple", 0.3f);
        quotations.put("orange", 0.7f);
        quotations.put("bread", 2.5f);
        quotations.put("cheese", 5f);
        quotations.put("chicken", 4.7f);
        quotations.put("mineral_water", 0.9f);
        quotations.put("instant_noodles", 9.8f);
    }

    public Quotation getQuotation(List<String> list) {
        Map<String, Float> quote = new HashMap<>();

        list.forEach(l -> quote.put(l, quotations.get(l)));

        if(quote.isEmpty() || quote.values().contains(null)) {
            return null;
        }

        return new Quotation(generateId(), quote);
    }

    private String generateId() {
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        while(sb.length() < 8) {
            sb.append(Integer.toHexString(sr.nextInt(15)));
        }

        return sb.toString();
    }

    public String createErrorJson(String msg) {
        return Json.createObjectBuilder().add("error", msg).build().toString();
    }
    
}
