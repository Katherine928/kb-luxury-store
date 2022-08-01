package com.katherine.katherine.dao;

import com.katherine.katherine.model.Bag;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBagDao implements BagDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBagDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Bag> getAllBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }

    @Override
    public List<Bag> getOnlineBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags WHERE online = '1';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }

    @Override
    public List<Bag> getWomenOnlineBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags WHERE online = '1' AND iconic = 'women';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }

    @Override
    public List<Bag> getMenOnlineBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags WHERE online = '1' AND iconic = 'men';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }

    @Override
    public List<Bag> getBagsByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic from bags WHERE color = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while(results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getWomenBagsByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic from bags WHERE color = ? and iconic = 'women';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while(results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getMenBagsByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic from bags WHERE color = ? and iconic = 'men';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while(results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getOnlineBagByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE color = ? and online = 1";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getWomenOnlineBagsByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE color = ? and online = 1 and iconic = 'women";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getMenOnlineBagsByColor(String color) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE color = ? and online = 1 and iconic = 'men";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getBagsByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getWomenBagsByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ? and iconic = 'women';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getMenBagsByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ? and iconic = 'men';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getOnlineBagByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ? AND online = 1";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getWomenOnlineBagsByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ? AND online = 1 and iconic = 'women';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getMenOnlineBagsByCategories(String categories) {
        List<Bag> bags = new ArrayList<>();
        String sql = "SELECT bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url,categories, iconic FROM bags WHERE categories = ? AND online = 1 and iconic = 'men';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categories);
        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }
        return bags;
    }

    @Override
    public List<Bag> getAllWomenBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags WHERE iconic = 'women';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }

    @Override
    public List<Bag> getAllMenBags() {
        List<Bag> bags = new ArrayList<>();

        String sql = " Select bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, categories, iconic from bags WHERE iconic = 'men';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Bag bag = mapRowToBag(results);
            bags.add(bag);
        }

        return bags;
    }


    @Override
    public void addNewBag(Bag bag) {
        String sql = "INSERT INTO bags (bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, online, categories, iconic) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, bag.getBag_id(), bag.getBag_name(), bag.getColor(), bag.getPrice(), bag.getMaterial(), bag.getBag_length(), bag.getBag_height(), bag.getBag_width(), bag.getDescription(), bag.getImage_url(), bag.getOnline(), bag.getCategories(), bag.getIconic());

    }


    private Bag mapRowToBag(SqlRowSet results) {

        Bag bag = new Bag();
        bag.setBag_id(results.getString("bag_id"));
        bag.setBag_name(results.getString("bag_name"));
        bag.setColor(results.getString("color"));
        BigDecimal price = results.getBigDecimal("price");
        assert price != null;
        bag.setPrice(price.setScale(2, RoundingMode.HALF_EVEN));
        bag.setMaterial(results.getString("material"));
        bag.setBag_length(results.getFloat("bag_length"));
        bag.setBag_height(results.getFloat("bag_height"));
        bag.setBag_width(results.getFloat("bag_width"));
        bag.setDescription(results.getString("description"));
        bag.setImage_url(results.getString("image_url"));
        bag.setCategories(results.getString("categories"));
        bag.setIconic(results.getString("iconic"));

        return bag;
    }
}
