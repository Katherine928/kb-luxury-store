package com.katherine.katherine.controller;


import com.katherine.katherine.dao.BagDao;
import com.katherine.katherine.model.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BagController {

    @Autowired(required=true)
    private BagDao bagDao;

    @RequestMapping(path = "/bags", method = RequestMethod.GET)
    public List<Bag> getbags() {
        return bagDao.getAllBags();
    }

    @RequestMapping(path = "/bags/women", method = RequestMethod.GET)
    public List<Bag> getAllWomenBags() {
        return bagDao.getAllWomenBags();
    }

    @RequestMapping(path = "/bags/men", method = RequestMethod.GET)
    public List<Bag> getAllMenBags() {
        return bagDao.getAllMenBags();
    }

    @RequestMapping(path = "/bags/online", method = RequestMethod.GET)
    public List<Bag> getOnlineBags() {
        return bagDao.getOnlineBags();
    }

    @RequestMapping(path = "/bags/women/online", method = RequestMethod.GET)
    public List<Bag> getWomenOnlineBags() {
        return bagDao.getWomenOnlineBags();
    }

    @RequestMapping(path = "/bags/men/online", method = RequestMethod.GET)
    public List<Bag> getMenOnlineBags() {
        return bagDao.getMenOnlineBags();
    }

    @RequestMapping(path = "/bags/colors/{color}", method = RequestMethod.GET)
    public List<Bag> getBagsByColor(@PathVariable String color) {
        return bagDao.getBagsByColor(color);
    }

    @RequestMapping(path = "/bags/colors/women/{color}", method = RequestMethod.GET)
    public List<Bag> getWomenBagsByColor(@PathVariable String color) {
        return bagDao.getWomenBagsByColor(color);
    }

    @RequestMapping(path = "/bags/colors/men/{color}", method = RequestMethod.GET)
    public List<Bag> getMenBagsByColor(@PathVariable String color) {
        return bagDao.getMenBagsByColor(color);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/bags/add", method = RequestMethod.POST)
    public void addNewBag(@RequestBody Bag bag) {
        bagDao.addNewBag(bag);
    }

    @RequestMapping(path = "/bags/online/{color}", method = RequestMethod.GET)
    public List<Bag> getOnlineBagByColor(@PathVariable String color) {
        return bagDao.getOnlineBagByColor(color);
    }

    @RequestMapping(path = "/bags/categories/{categories}", method = RequestMethod.GET)
    public List<Bag> getBagByCategories(@PathVariable String categories) {
        return bagDao.getBagsByCategories(categories);
    }

    @RequestMapping(path = "/bags/online/categories/{categories}", method = RequestMethod.GET)
    public List<Bag> getOnlineBagByCategories(@PathVariable String categories) {
        return bagDao.getOnlineBagByCategories(categories);
    }
}
