package com.rest;

import com.model.Stamp;
import com.service.ProducerService;
import com.service.StampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/")
public class StampsRestService {

    @Autowired
    private StampsService stampsService;

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "/stamps", method = RequestMethod.POST)
    public ResponseEntity<Object> see_all() {
        return ResponseEntity.ok(stampsService.listAll());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        stampsService.delete(id);
    }

    @RequestMapping(value = "/stamps/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> find_by_id(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(stampsService.find(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestParam("mode") Boolean mode,
                       @RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("year") Integer year,
                       @RequestParam("price") double price,
                       @RequestParam("image") String image)
    {
        if (mode) {
            Stamp new_stamp = new Stamp(name, year, price, image);
            producerService.produce(new_stamp);
            // ResponseEntity.ok(stampsService.add(new_stamp));
            String str = "Марка успешно добавлена";
            return "SUCCESSFULLY ADDED!";
        }
        else {
            ResponseEntity.ok(stampsService.add(new Stamp(id, name, year, price, image)));
            return "SUCCESSFULLY EDITED!";
        }
    }
}
