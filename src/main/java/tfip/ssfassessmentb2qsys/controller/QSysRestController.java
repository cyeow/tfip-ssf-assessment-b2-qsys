package tfip.ssfassessmentb2qsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfip.ssfassessmentb2qsys.model.Quotation;
import tfip.ssfassessmentb2qsys.service.QSysService;

@RestController
@RequestMapping("/quotation")
public class QSysRestController {
    
    @Autowired
    QSysService svc;
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getQuotation(@RequestBody List<String> list) {
        Quotation q = svc.getQuotation(list);

        if(q == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Content-Type", MediaType.APPLICATION_JSON_VALUE).body(svc.createErrorJson("Either the list is empty, or one or more items does not exist."));
        }

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", MediaType.APPLICATION_JSON_VALUE).body(q.toJSONString());
    }
}
