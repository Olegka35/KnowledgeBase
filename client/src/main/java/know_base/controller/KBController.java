package know_base.controller;

import know_base.controller.methods.AddLabel;
import know_base.controller.methods.AddNewRecord;
import know_base.controller.methods.File;
import know_base.controller.methods.LabelsIDs;
import know_base.services.KnowBaseServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
public class KBController {
    @Autowired
    KnowBaseServiceClient service;


    @RequestMapping(value = "/records")
    public ResponseEntity<Map> getRecords(@RequestParam(value = "label", required = false) String label) {
        if(label == null)
            return new ResponseEntity<>(service.getRecords(), HttpStatus.OK);
        return new ResponseEntity<>(service.getRecordsByLabel(label), HttpStatus.OK);
    }

    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public ResponseEntity<Object> addRecord(@RequestBody AddNewRecord request) {
        service.addRecord(request.getTitle(), request.getText());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/labels/{recordID}", method = RequestMethod.POST)
    public ResponseEntity<Object> addRecord(@PathVariable("recordID") BigInteger recordID, @RequestBody LabelsIDs labelsIDs) {
        service.addLabelsToRecord(recordID, labelsIDs.getLabelIDs());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/file/{recordID}", method = RequestMethod.POST)
    public ResponseEntity<Object> addFile(@PathVariable("recordID") BigInteger recordID, @RequestBody File file) {
        service.addFileToRecord(recordID, file.getName(), file.getBytes());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/file/{recordID}/{name}")
    public ResponseEntity<List> getFile(@PathVariable("recordID") BigInteger recordID, @PathVariable("name") String fileName) {
        List<Short> bytes = service.getFile(recordID, fileName);
        return new ResponseEntity<>(bytes, HttpStatus.OK);
    }

    @RequestMapping(value = "/label", method = RequestMethod.POST)
    public ResponseEntity<Object> addLabel(@RequestBody AddLabel request) {
        service.addLabel(request.getText());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
