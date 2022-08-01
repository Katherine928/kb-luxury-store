package com.katherine.katherine.dao;

import com.katherine.katherine.model.Bag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;



@Component
@CrossOrigin
public interface BagDao {
    List<Bag> getAllBags();
    List<Bag> getOnlineBags();
    List<Bag> getWomenOnlineBags();
    List<Bag> getMenOnlineBags();
    List<Bag> getBagsByColor(String color);
    List<Bag> getWomenBagsByColor(String color);
    List<Bag> getMenBagsByColor(String color);
    List<Bag> getOnlineBagByColor(String color);
    List<Bag> getWomenOnlineBagsByColor(String color);
    List<Bag> getMenOnlineBagsByColor(String color);
    List<Bag> getBagsByCategories(String categories);
    List<Bag> getWomenBagsByCategories(String categories);
    List<Bag> getMenBagsByCategories(String categories);
    List<Bag> getOnlineBagByCategories(String categories);
    List<Bag> getWomenOnlineBagsByCategories(String categories);
    List<Bag> getMenOnlineBagsByCategories(String categories);
    List<Bag> getAllWomenBags();
    List<Bag> getAllMenBags();
    void addNewBag(Bag bag);
}
